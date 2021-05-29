import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { TimesheetService } from 'src/shared/timesheet.service';

@Component({
  selector: 'app-changepass',
  templateUrl: './changepass.component.html',
  styleUrls: ['./changepass.component.css']
})
export class ChangepassComponent implements OnInit {
  id:any;
  UserObj:any;
  tempObj:any;
  constructor(private _timesheetSer:TimesheetService,private _router:Router) { }

  ngOnInit(): void {
    this.id=sessionStorage.getItem("empid");
    this._timesheetSer.getEmp(this.id).subscribe((res)=>{
      this.UserObj=res;
  });
}
  

  saveCred(val:any)
  {
    const userObj={email:this.UserObj.email,password:val.pass};
    this._timesheetSer.saveCred(userObj).subscribe((res)=>{
      this.tempObj=res;
      if(this.tempObj!=null)
      {
        alert("success");
        this._router.navigate(['/empdash']);
      }
    })
  }

}
