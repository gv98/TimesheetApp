import { analyzeAndValidateNgModules } from '@angular/compiler';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { TimesheetService } from 'src/shared/timesheet.service';

@Component({
  selector: 'app-editemployee',
  templateUrl: './editemployee.component.html',
  styleUrls: ['./editemployee.component.css']
})
export class EditemployeeComponent implements OnInit {

  id:any;
  UserObj:any;

  constructor(private _timesheetSer:TimesheetService,private _router:Router) {
    
   }

  ngOnInit(): void {
    this.id=sessionStorage.getItem("empid");
    this._timesheetSer.getEmp(this.id).subscribe((res)=>{
      this.UserObj=res;
    })
  }

  saveEmp(val:any)
  {
    const UserObj={empid:this.UserObj.empid,name:val.name,designation:val.designation,dob:val.dob,
      salary:val.salary,address:val.address,email:val.email,mobile:val.mobile
    }
    this._timesheetSer.editEmp(UserObj).subscribe((res)=>{
      this.UserObj=res;
      if(this.UserObj!=null)
      {
        alert("Details Updated!");
        this._router.navigate(['/admindash']);
      }
      else
      {
        alert("Updation Failed! Try Again Later!");
        this._router.navigate(['/editemp']);
      }
    });
  }



}
