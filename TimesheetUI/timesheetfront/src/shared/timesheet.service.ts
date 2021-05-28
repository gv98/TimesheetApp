import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { IEmployee } from './interface/iemployee.model';
import { baseUrl } from './constants/constant';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class TimesheetService {

  constructor(private _http:HttpClient) { }

  showAll():Observable<IEmployee[]>{
    const Url:string=`${baseUrl}/employees`;
    return this._http.get<IEmployee[]>(Url);
  }
}
