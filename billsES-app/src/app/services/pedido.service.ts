import { Injectable } from '@angular/core';
import { Pedido } from '../classes/pedido';
import { HttpHeaders, HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { map } from 'rxjs/internal/operators/map';

@Injectable({
  providedIn: 'root'
})
export class PedidoService {

  private urlEndPoint: string = 'http://localhost:8080/api/pedidos';
  private httpHeaders = new HttpHeaders({ 'Content-Type': 'application/json' });


  constructor(private  HttpOrder: HttpClient) { }



  getPedidos(): Observable<Pedido[]> {
    return this.HttpOrder.get(this.urlEndPoint).pipe(
      map(response => response as Pedido[])
    );
  }

  create(pedido: Pedido): Observable<Pedido> {
    return this.HttpOrder.post<Pedido>(this.urlEndPoint, pedido, {headers: this.httpHeaders});
  }

  getPedido(id): Observable<Pedido> {
    return this.HttpOrder.get<Pedido>(`${this.urlEndPoint}/${id}`);
  }

  update(pedido: Pedido): Observable<Pedido> {
    return this.HttpOrder.put<Pedido>(`${this.urlEndPoint}`, pedido, {headers: this.httpHeaders});
  }

  delete(id: number): Observable<Pedido> {
    return this.HttpOrder.delete<Pedido>(`${this.urlEndPoint}/${id}`, {headers: this.httpHeaders});
  }
}
