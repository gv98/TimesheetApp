import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { TimesheetService } from 'src/shared/timesheet.service';

@Component({
  selector: 'app-addtimesheet',
  templateUrl: './addtimesheet.component.html',
  styleUrls: ['./addtimesheet.component.css']
})
export class AddtimesheetComponent implements OnInit {
  tempObj:any;
  empid:any;
  constructor(private _timesheetSer:TimesheetService,private _router:Router) { }

  ngOnInit(): void {
    this.empid=sessionStorage.getItem("empid");
  }

  saveSheet(val:any)
  {
    const UserObj={empidl:this.empid ,dat:val.idate,attendance:val.time,status:"saved"};
    this._timesheetSer.addtimesheet(UserObj).subscribe((res)=>{
      this.tempObj=res;
      if(this.tempObj!=null)
      {
        alert("Success!");
        this._router.navigate(['/timesheetdash'])
      }
      else
      {
        alert("Failed!")
      }
    });
  }

}
