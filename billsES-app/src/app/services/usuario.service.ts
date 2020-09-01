import { Injectable } from '@angular/core';
import { Usuario } from '../classes/usuario';
import { USUARIOS } from 'src/app/classes/usuario.json';
import { of, Observable, throwError } from 'rxjs';
import { HttpHeaders, HttpClient } from '@angular/common/http';
import { map, catchError } from 'rxjs/operators/';
import swal2 from 'sweetalert2';

import { Router } from '@angular/router';



@Injectable({
  providedIn: 'root'
})
export class UsuarioService {

/*
   usuario: Usuario[] = [
    new Usuario( 'JhonDoe', 'M@fth76','USER');

  ]; */


  private urlEndPoint: string = 'http://localhost:8080/api/usuarios';
  private httpHeaders = new HttpHeaders({ 'Content-Type': 'application/json' });


  constructor(private HttpUser: HttpClient,
              private router: Router) { }

  getUsuarios(): Observable<Usuario[]> {
    return this.HttpUser.get(this.urlEndPoint).pipe(
      map(response => response as Usuario[])
    );



  }

  create(usuario: Usuario): Observable<Usuario> {
    return this.HttpUser.post<Usuario>(this.urlEndPoint, usuario, {headers: this.httpHeaders});

  };

  getUsuario(id): Observable<Usuario> {
    return this.HttpUser.get<Usuario>(`${this.urlEndPoint}/${id}`).pipe(
      catchError(e => {
        this.router.navigate(['/users']);
        console.error(e.error.mensaje);
        swal2.fire('Error al editar', e.error.mensaje, 'error');
        return throwError(e);
      })
    );
  }

  update(usuario: Usuario): Observable<Usuario> {
    return this.HttpUser.put<Usuario>(`${this.urlEndPoint}`, usuario , {headers: this.httpHeaders}) ;
  }

  delete(id: number): Observable<Usuario> {
    return this.HttpUser.delete<Usuario>(`${this.urlEndPoint}/${id}`, {headers: this.httpHeaders});
  }
/*
  agregarUsuario(usuario: Usuario) {
    this.usuario.push(usuario);
  }
 */

}
