import { Component, OnInit, TemplateRef } from '@angular/core';
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
  constructor(private _timesheetSer:TimesheetService,private modalService: BsModalService) { }

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

}
