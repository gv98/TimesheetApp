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

  adminLogin(id:any,pass:any)
  {
    const Url=`${baseUrl}/admin/login?id=${id}&pass=${pass}`;
    return this._http.get(Url);
  }

  customDateReport(val:string)
  {
    const Url=`${baseUrl}/admin/getcustomdatesreport?str=${val}`;
    return this._http.get(Url);
  }

  addleave(val:any)
  {
    const Url=`${baseUrl}/admin/createleave`;
    return this._http.post(Url,val);
  }

  viewLeaveTypes()
  {
    const Url=`${baseUrl}/admin/viewleavetypes`;
    return this._http.get(Url);
  }

  deleteLeave(val:String)
  {
    const url=`${baseUrl}/admin/deleteleavetype?val=${val}`;
    return this._http.delete(url);
  }

  Login(user:any){
    const Url=`${baseUrl}/employees/login?email=${user.email}&password=${user.password}`;
    return this._http.get(Url);
  }
  signIn(user:any){
    sessionStorage.setItem("employee",user);
  }

  signInEmp(user:any){
    sessionStorage.setItem("empid",user);
  }

  approveSheet(id:number,dat:string)
  {
    const Url=`${baseUrl}/admin/approvetime?empid=${id}&dat=${dat}`;
    return this._http.get(Url);
  }

  addtimesheet(val:any)
  {
    const Url=`${baseUrl}/employee/addtimesheet`;
    return this._http.post(Url,val);
  }

  customTimeReport(val:number)
  {
    const Url=`${baseUrl}/admin/getcustomtimereport?empid=${val}`;
    return this._http.get(Url);
  }

  submitTime(empid:number,dat:string)
  {
    const Url=`${baseUrl}/admin/submittime?empid=${empid}&dat=${dat}`;
    return this._http.get(Url);
  }

}
