import { Observable } from 'rxjs/internal/Observable';
import { Injectable } from '@angular/core';
import { HttpHeaders, HttpClient } from '@angular/common/http';
import { Revision } from '../classes/revision';
import { map } from 'rxjs/internal/operators/map';

@Injectable({
  providedIn: 'root'
})
export class RevisionService {

  private urlEndPoint : string = 'http://localhost:8080/api/revisiones';
  private httpHeaders = new HttpHeaders({ 'Content-Type': 'application/json' });

  constructor(private HttpReview: HttpClient) { }

  getRevisiones(): Observable<Revision[]> {
    return this.HttpReview.get(this.urlEndPoint).pipe(
        map(response => response as Revision[])
    );
  }

  create(revision: Revision): Observable<Revision> {
    return this.HttpReview.post<Revision>(this.urlEndPoint, revision, {headers: this.httpHeaders});
  }


  getRevision(id): Observable<Revision> {
    return this.HttpReview.get<Revision>(`${this.urlEndPoint}/${id}`);
  }

  update(revision: Revision): Observable<Revision> {
    return this.HttpReview.put<Revision>(`${this.urlEndPoint}`, revision, {headers: this.httpHeaders});
  }

  delete(id: number): Observable<Revision> {
    return this.HttpReview.delete<Revision>(`${this.urlEndPoint}/${id}`, {headers: this.httpHeaders});
  }


}
