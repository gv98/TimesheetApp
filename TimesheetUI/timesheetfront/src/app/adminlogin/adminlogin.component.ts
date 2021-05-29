import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { TimesheetService } from 'src/shared/timesheet.service';

@Component({
  selector: 'app-adminlogin',
  templateUrl: './adminlogin.component.html',
  styleUrls: ['./adminlogin.component.css']
})
export class AdminloginComponent implements OnInit {

  constructor(private _timesheetSer:TimesheetService,private _router:Router) { }

  temp:any;
  ngOnInit(): void {
  }

  loginUser(val:any)
  {
    this._timesheetSer.adminLogin(val.id,val.pass).subscribe((res)=>{
      this.temp=res;
      if(this.temp!=null)
      {
        sessionStorage.setItem("admin","123");
        this._router.navigate(['/admindash']);
      }
      else
      {
        alert("Invalid Credentials!")
        this._router.navigate(['/home'])
      }
    })
  }

}
