import { Injectable } from '@angular/core';
import { Producto } from '../classes/producto';
/* import { PRODUCTOS } from '../classes/productos.json'; */
import { of, Observable } from 'rxjs';

import { HttpClient, HttpHeaders } from '@angular/common/http';
import { map } from 'rxjs/operators';
//import { map } from 'rxjs/internal/operators/map';


@Injectable({
  providedIn: 'root'
})
export class ProductoService {

  private urlEndPoint: string = 'http://localhost:8080/api/productos';
  private urlEndPointImage: string = 'http://localhost:808/api/productos/add';
  private httpHeaders = new HttpHeaders({'Content-Type': 'application/json'});

  constructor(private httpProducts: HttpClient ) { }



  getProductos(): Observable<Producto[]> {
    //<Producto[]>(this.urlEndPoint);
   // return of(PRODUCTOS);
    return this.httpProducts.get(this.urlEndPoint).pipe(
      map(response => response as Producto[])

    );
  }

  create(producto: Producto): Observable<Producto> {
    return this.httpProducts.post<Producto>(this.urlEndPoint, producto, {headers: this.httpHeaders} )
  }


  getProducto(id): Observable<Producto> {
    return this.httpProducts.get<Producto>(`${this.urlEndPoint}/${id}`)
  }

  update(producto: Producto): Observable<Producto> {
    return this.httpProducts.put<Producto>(`${this.urlEndPoint}/${producto.id}`, producto, { headers: this.httpHeaders })
  }

  addImage(producto: Producto): Observable<Producto> {
    return this.httpProducts.post<Producto> (this.urlEndPointImage, producto, {headers: this.httpHeaders});
  }


  delete(id: number): Observable<Producto> {
    return this.httpProducts.delete<Producto>(`${this.urlEndPoint}/${id}`, { headers: this.httpHeaders });
  }

}
