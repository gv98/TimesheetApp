import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { TimesheetService } from 'src/shared/timesheet.service';

@Component({
  selector: 'app-add-employee',
  templateUrl: './add-employee.component.html',
  styleUrls: ['./add-employee.component.css']
})
export class AddEmployeeComponent implements OnInit {

  constructor(private _timesheetSer:TimesheetService,private _router:Router) { }

  tempObj:any;
  ngOnInit(): void {
  }

  saveUser(val:any)
  {
      const userObj={
        name:val.name,address:val.address,
        designation:val.designation,email:val.email,salary:val.salary,dob:val.dob,mobile:val.mobile
      }
      this._timesheetSer.saveAccount(userObj).subscribe((res)=>{
        this.tempObj=res;
        this.saveCred(val.email,val.password);
        alert("Record added!");
        this._router.navigate(['/admindash']);
    });
  }
  saveCred(val:any,pass:any)
  {
    const userObj={email:val,password:pass};
    this._timesheetSer.saveCred(userObj).subscribe(()=>{

    })
  }

}
