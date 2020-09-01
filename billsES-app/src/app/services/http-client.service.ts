import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Usuario } from '../classes/usuario';
import { of, Observable, throwError} from 'rxjs';
import swal from 'sweetalert2';

import { USUARIOS } from 'src/app/classes/usuario.json'
import { map, catchError } from 'rxjs/operators';
import { Router, ActivatedRoute } from '@angular/router';

@Injectable({
  providedIn: 'root'
})
export class HttpClientService {


  // tslint:disable-next-line: no-inferrable-types
  private urlEndPoint: string = 'http://localhost:8080/api/usuarios';
  private httpHeaders = new HttpHeaders({ 'Content-Type': 'application/json' });



  constructor(private HttpUsers: HttpClient,
    private router: Router,
    private activateRouter: ActivatedRoute) { }

  getUsuarios():Observable<Usuario[]> {
    //<Usuario[]>(this.urlEndPoint);
    //return of(USUARIOS)
    return this.HttpUsers.get(this.urlEndPoint).pipe(
      map(response => response as Usuario[])
    );
  }

  //metodo que retorna un objeto usuario
  create(usuario: Usuario): Observable<Usuario> {
    return this.HttpUsers.post(this.urlEndPoint, usuario, {headers: this.httpHeaders}).pipe(
      map((response:any) => response.cliente as Usuario),
      catchError(e => {
        console.error(e.error.mensaje);
        swal.fire(e.error.mensaje, e.error.error, 'error');
        return throwError(e);
      })
    );
  }

  getUsuario(id): Observable<Usuario> {
    return this.HttpUsers.get<Usuario>(`${this.urlEndPoint}/${id}`).pipe(
      catchError(e => {
        this.router.navigate(['/users']);
        console.error(e.error.mensaje);
        swal.fire('Error al editar', e.error.mensaje, 'error');
        return throwError(e);
      })
    );
  }

  update(usuario : Usuario): Observable<Usuario>{
    return this.HttpUsers.put(`${this.urlEndPoint}/${usuario.id}`,usuario,{headers: this.httpHeaders}).pipe(
      map( (response: any) => response.usuario as Usuario),
      catchError(e => {
        console.error(e.error.mensaje);
        swal.fire(e.error.mensaje, e.error.error, 'error');
        return throwError(e);
      })
    )
  }

  delete(id: number): Observable<Usuario> {
    return this.HttpUsers.delete<Usuario>(`${this.urlEndPoint}/${id}`,{headers: this.httpHeaders}).pipe(
      catchError(e => {
        console.error(e.error.mensaje);
        swal.fire(e.error.mensaje, e.error.error, 'error');
        return throwError(e);
      })
    )
  }

/*    addUser(usuarioNuevo: Usuario) {
    return this.HttpUsers.post<Usuario>(this.urlEndPoint, usuarioNuevo, {headers:this.httpHeaders});
  } */

}
