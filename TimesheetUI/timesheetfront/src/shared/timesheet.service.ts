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

  saveAccount(user:any)
  {
    const Url=`${baseUrl}/employees/create`;
    return this._http.post(Url,user);
  }

  saveCred(user:any)
  {
    const Url=`${baseUrl}/employees/createauth`;
    return this._http.post(Url,user);
  }

  getEmp(empid:number)
  {
    const Url:string=`${baseUrl}/employees/${empid}`;
    return this._http.get<IEmployee>(Url);
  }

  editEmp(user:any)
  {
    const Url=`${baseUrl}/employees/edit`;
    return this._http.put(Url,user);
  }

  deleteEmp(empid:any)
  {
    const url=`${baseUrl}/employees/${empid}`;
    return this._http.delete(url);
  }

}
