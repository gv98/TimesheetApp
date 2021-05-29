import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { TimesheetService } from 'src/shared/timesheet.service';

@Component({
  selector: 'app-timesheetdash',
  templateUrl: './timesheetdash.component.html',
  styleUrls: ['./timesheetdash.component.css']
})
export class TimesheetdashComponent implements OnInit {

  empArray:any=[];
  id:any;
  constructor(private _timesheetSer:TimesheetService,private _router:Router) { }

  ngOnInit(): void {
    this.id=sessionStorage.getItem("empid");
    console.log(this.id);
    this.showAll(this.id);

  }

  showAll(val:number)
  {
    
    this._timesheetSer.customTimeReport(val).subscribe((res)=>{
      this.empArray=res;
      console.log(this.empArray);
    });
  }

  submitTime(dat:string)
  {
    if(confirm("Are You Sure?"))
    {
      this._timesheetSer.submitTime(this.id,dat).subscribe((res)=>{
        this.showAll(this.id);
      });
      
    }
    
  }

}
