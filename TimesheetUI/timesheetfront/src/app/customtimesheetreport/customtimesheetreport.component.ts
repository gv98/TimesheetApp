import { Component, OnInit } from '@angular/core';
import { TimesheetService } from 'src/shared/timesheet.service';

@Component({
  selector: 'app-customtimesheetreport',
  templateUrl: './customtimesheetreport.component.html',
  styleUrls: ['./customtimesheetreport.component.css']
})
export class CustomtimesheetreportComponent implements OnInit {

  empArray:any=[];
  constructor(private _timesheetSer:TimesheetService) { }

  ngOnInit(): void {
  }

  showAll(val:any)
  {
    this._timesheetSer.customDateReport(val.idate).subscribe((res)=>{this.empArray=res});
  }

  Approve(id:any,dat:any)
  {
    this._timesheetSer.approveSheet(id,dat).subscribe();
    const val:any={idate:dat};
    this.showAll(val);
  }

}
