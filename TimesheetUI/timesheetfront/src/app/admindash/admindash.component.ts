import { Component, OnInit, TemplateRef } from '@angular/core';
import { Router } from '@angular/router';
import { BsModalService } from 'ngx-bootstrap/modal';
import { TimesheetService } from 'src/shared/timesheet.service';

@Component({
  selector: 'app-admindash',
  templateUrl: './admindash.component.html',
  styleUrls: ['./admindash.component.css']
})
export class AdmindashComponent implements OnInit {

  modalRef: any;
  empArray:any=[];
  p:number=1;
  term:string="";
  constructor(private _timesheetSer:TimesheetService,private modalService: BsModalService
    ,private _router:Router) { }

  ngOnInit(): void {
    this.showAll();
  }

  openModal(template: TemplateRef<any>) {
    this.modalRef = this.modalService.show(template);
  }

  showAll()
  {
    this._timesheetSer.showAll().subscribe((res)=>{this.empArray=res});
  }
  editEmp(val:any)
  {
    sessionStorage.setItem("empid",val);
    this._router.navigate(['/editemp']);
  }

  deleteEmp(val:any)
  {
    if(confirm("Are you sure"))
    {
      this._timesheetSer.deleteEmp(val).subscribe((res)=>{
        this.empArray=res;
        if(this.empArray!=null)
    {
      this.showAll();
      alert("Success");
    }
    else
    {
      alert("deletion failed")
    }
      })
    }
    
    
  }

}
