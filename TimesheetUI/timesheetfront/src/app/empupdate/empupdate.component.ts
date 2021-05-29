import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { TimesheetService } from 'src/shared/timesheet.service';

@Component({
  selector: 'app-empupdate',
  templateUrl: './empupdate.component.html',
  styleUrls: ['./empupdate.component.css']
})
export class EmpupdateComponent implements OnInit {
  id:any;
  UserObj:any;
  constructor(private _timesheetSer:TimesheetService,private _router:Router) { }

  ngOnInit(): void {
    this.id=sessionStorage.getItem("empid");
    this._timesheetSer.getEmp(this.id).subscribe((res)=>{
      this.UserObj=res;
    })
  }

  saveEmp(val:any)
  {
    const UserObj={empid:this.UserObj.empid,name:val.name,designation:this.UserObj.designation,dob:val.dob,
      salary:this.UserObj.salary,address:val.address,email:this.UserObj.email,mobile:val.mobile
    }
    this._timesheetSer.editEmp(UserObj).subscribe((res)=>{
      this.UserObj=res;
      if(this.UserObj!=null)
      {
        alert("Details Updated!");
        this._router.navigate(['/empdash']);
      }
      else
      {
        alert("Updation Failed! Try Again Later!");
        this._router.navigate(['/empdash']);
      }
    });
  }

}
