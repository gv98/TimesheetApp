import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { TimesheetService } from 'src/shared/timesheet.service';

@Component({
  selector: 'app-leaveapplication',
  templateUrl: './leaveapplication.component.html',
  styleUrls: ['./leaveapplication.component.css']
})
export class LeaveapplicationComponent implements OnInit {
  ltypeArray:any=[];
  leaveArray:any=[];
  empid:any;
  emp:any;
  templeave:any;
  constructor(private _timesheetSer:TimesheetService,private _router:Router) { }

  ngOnInit(): void {
    this._timesheetSer.viewLeaveTypes().subscribe((res)=>{
      this.ltypeArray=res;
      console.log(this.ltypeArray);
    })

    this.empid=sessionStorage.getItem("empid");
    this._timesheetSer.getEmp(this.empid).subscribe((res)=>{
      this.emp=res;
      console.log(this.emp);
    })

    this.leaveReportById(this.empid);

    
    
  }

  addLeave(val:any)
  {
    const leaveObj={empid:this.emp.empid,empname:this.emp.name,dat:val.idate,ltype:val.ltyp,status:'submitted'}
    console.log(leaveObj);
    this._timesheetSer.applyLeave(leaveObj).subscribe((res)=>{
      this.templeave=res;
      if(this.templeave!=null)
      {
        alert("Success");
        this.leaveReportById(this.empid);
        console.log(this.templeave);
      }
      else
      {
        alert("Failed");
      }
    })
  }

  leaveReportById(val:any)
  {
    this._timesheetSer.getLeaveReportById(val).subscribe((res)=>{
      this.leaveArray=res;
    })
  }

}
