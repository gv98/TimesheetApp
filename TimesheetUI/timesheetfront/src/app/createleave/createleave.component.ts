import { Component, OnInit } from '@angular/core';
import { TimesheetService } from 'src/shared/timesheet.service';

@Component({
  selector: 'app-createleave',
  templateUrl: './createleave.component.html',
  styleUrls: ['./createleave.component.css']
})
export class CreateleaveComponent implements OnInit {

  leaveObj:any;
  constructor(private _timesheetSer:TimesheetService) { }

  ngOnInit(): void {
    this.showAll();
  }

  createleave(val:any)
  {
    this.leaveObj={name:val.ltype};
    this._timesheetSer.addleave(this.leaveObj).subscribe((res)=>{
      this.leaveObj=res;
      if(this.leaveObj!=null)
      {
        this.showAll();
        alert("Leave Type Created");
        
      }
      else
      {
        alert("Failed!");
      }
    })
    
  }

  showAll()
  {
    this._timesheetSer.viewLeaveTypes().subscribe((res)=>{this.leaveObj=res});
  }

  deleteLeave(val:string)
  {
    if(confirm("Are You Sure?"))
    {
      this._timesheetSer.deleteLeave(val).subscribe()
      this.showAll();
    }
    
  }

}
