import { Component, OnInit } from '@angular/core';
import { TimesheetService } from 'src/shared/timesheet.service';

@Component({
  selector: 'app-empdash',
  templateUrl: './empdash.component.html',
  styleUrls: ['./empdash.component.css']
})
export class EmpdashComponent implements OnInit {

  emp:any
  constructor(private _timesheetSer:TimesheetService) { }

  ngOnInit(): void {
    this.getUser(sessionStorage.getItem("empid"));
  }

  getUser(val:any)
  {
    this._timesheetSer.getEmp(val).subscribe((res)=>{
      this.emp=res;
    })
  }


}
