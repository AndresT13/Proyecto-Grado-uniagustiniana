import { Injectable } from '@angular/core';

import { Observable } from 'rxjs';
import { Categoria } from '../classes/categoria';



import { HttpClient, HttpHeaders } from '@angular/common/http';
import { map } from 'rxjs/internal/operators/map';


@Injectable({
  providedIn: 'root'
})

export class CategoriaService {


  private urlEndPoint: string = 'http://localhost:8080/api/categorias';
  private httpHeaders = new HttpHeaders({ 'Content-Type': 'application/json' });


  constructor(private HttpCategories: HttpClient ) { }


    getCategorias(): Observable<Categoria[]> {
      return this.HttpCategories.get(this.urlEndPoint).pipe(
        map(response => response as Categoria[])
      );
    }

    create(categoria: Categoria): Observable<Categoria> {
      return this.HttpCategories.post<Categoria>(this.urlEndPoint, categoria, {headers: this.httpHeaders });
    }

      getCategoria(id): Observable<Categoria> {
        return this.HttpCategories.get<Categoria>(`${this.urlEndPoint}/${id}`);
    }

    update(categoria: Categoria): Observable<Categoria> {
      return this.HttpCategories.put<Categoria>(`${this.urlEndPoint}/${categoria.id}`, categoria,  {headers: this.httpHeaders});
    }

    delete(id: number): Observable<Categoria> {
      return this.HttpCategories.put<Categoria>(`${this.urlEndPoint}/${id}`, {headers: this.httpHeaders})
    }
  }

