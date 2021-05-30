import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { TimesheetService } from 'src/shared/timesheet.service';

@Component({
  selector: 'app-leavereport',
  templateUrl: './leavereport.component.html',
  styleUrls: ['./leavereport.component.css']
})
export class LeavereportComponent implements OnInit {

  leaveArray:any=[];
  constructor(private _timesheetSer:TimesheetService,private _router:Router) { }

  ngOnInit(): void {
    this.showAll();
  }

  Approve(id:number,dat:string)
  {
    this._timesheetSer.approveLeave(id,dat).subscribe(()=>{
    this.showAll();
    });
    
  }

  showAll()
  {
    this._timesheetSer.getLeaveApps().subscribe((res)=>{this.leaveArray=res});
  }

}
