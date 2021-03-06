import { Component, OnInit } from '@angular/core';
import { TimesheetService } from 'src/shared/timesheet.service';

@Component({
  selector: 'app-monthwisereport',
  templateUrl: './monthwisereport.component.html',
  styleUrls: ['./monthwisereport.component.css']
})
export class MonthwisereportComponent implements OnInit {

  empArray:any=[];
  constructor(private _timesheetSer:TimesheetService) { }

  ngOnInit(): void {
  }

  showAll(val:any)
  {
    this._timesheetSer.customMonthReport(val.idate).subscribe((res)=>{this.empArray=res});
  }

  Approve(id:any,dat:any)
  {
    this._timesheetSer.approveSheet(id,dat).subscribe(()=>{
      const val:any={idate:dat};
    this.showAll(val);
    });
    
  }

}
