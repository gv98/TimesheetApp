import { Component, OnInit } from '@angular/core';
import { TimesheetService } from 'src/shared/timesheet.service';

@Component({
  selector: 'app-yearwisereport',
  templateUrl: './yearwisereport.component.html',
  styleUrls: ['./yearwisereport.component.css']
})
export class YearwisereportComponent implements OnInit {

  empArray:any=[];
  constructor(private _timesheetSer:TimesheetService) { }

  ngOnInit(): void {
  }

  showAll(val:any)
  {
    this._timesheetSer.customYearReport(val.idate).subscribe((res)=>{this.empArray=res});
  }

  Approve(id:any,dat:any)
  {
    this._timesheetSer.approveSheet(id,dat).subscribe(()=>{
      const val:any={idate:dat};
    this.showAll(val);
    });
    
  }

}
