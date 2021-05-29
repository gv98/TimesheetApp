import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { TimesheetService } from 'src/shared/timesheet.service';

@Component({
  selector: 'app-updatetimesheet',
  templateUrl: './updatetimesheet.component.html',
  styleUrls: ['./updatetimesheet.component.css']
})
export class UpdatetimesheetComponent implements OnInit {

  temp:any;
  pid:any;
  dat:any;
  attendance:any;
  status:any;
  empid:any;
  constructor(private _timesheetSer:TimesheetService,private _router:Router) {
   }

  ngOnInit(): void {
    this.pid=sessionStorage.getItem("pid");
    this._timesheetSer.getLogById(this.pid).subscribe((res)=>{
      this.temp=res;
      console.log(this.temp);
    })
    // this.dat=sessionStorage.getItem("dat");
    // this.attendance=sessionStorage.getItem("attendance");
    // this.status=sessionStorage.getItem("status");
    // this.empid=sessionStorage.getItem("empid");


  }
  updateSheet(val:any)
  {
    const UserObj={pid:this.temp.pid,empidl:this.temp.empidl ,dat:val.idate,attendance:val.time,status:this.temp.status}
    console.log(UserObj);
    this._timesheetSer.updateTimeSheet(UserObj).subscribe((res)=>{
      this.temp=res;
      if(this.temp!=null)
      {
        alert("success!");
        this._router.navigate(['/timesheetdash']);
      }
      else
      {
        alert("failed!");
      }
    })
  }

}
