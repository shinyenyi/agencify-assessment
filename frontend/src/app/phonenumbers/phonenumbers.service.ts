import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { PhonenumbersRequest } from './phonenumbers-request-response';

@Injectable({
  providedIn: 'root'
})
export class PhonenumbersService {

  GET_PHONENUMBERS_URL = "http://localhost:8080/backend/phonenumbers";

  constructor(private http: HttpClient) { }

  getCustomerPhonenumbers(phonenumbersRequest: PhonenumbersRequest): Observable<string[]> {
    const httpOptions = {
      headers: new HttpHeaders({})
    }

    return this.http.post<string[]>(this.GET_PHONENUMBERS_URL, phonenumbersRequest, httpOptions);
  }
}
