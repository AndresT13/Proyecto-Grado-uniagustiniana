import { Injectable } from '@angular/core';
import { Marca } from '../classes/marca';
import { HttpHeaders, HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs/internal/Observable';
import { map } from 'rxjs/internal/operators/map';

@Injectable({
  providedIn: 'root'
})
export class MarcaService {

  private urlEndPoint: string = 'http://localhost:8080/api/marcas';
  private httpHeaders = new HttpHeaders({ 'Content-Type': 'application/json' });
  constructor(private HttpBrands: HttpClient) { }

  getMarcas():Observable<Marca[]> {
    return this.HttpBrands.get(this.urlEndPoint).pipe (
      map(response => response as Marca[])
    );
  }

  create(marca: Marca): Observable<Marca> {
    return this.HttpBrands.post<Marca>(this.urlEndPoint, marca, {headers: this.httpHeaders});
  }

  getMarca(id): Observable<Marca> {
    return this.HttpBrands.get<Marca>(`${this.urlEndPoint}/${id}`)
  }

  update(marca: Marca): Observable<Marca> {
    return this.HttpBrands.put<Marca>(`${this.urlEndPoint}/${marca.id}`, marca, { headers:this.httpHeaders });
  }

  delete(id: number): Observable<Marca> {
    return this.HttpBrands.delete<Marca> (`${this.urlEndPoint}/${id}`,{headers:this.httpHeaders})
  }

}
