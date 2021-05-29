import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { TimesheetService } from 'src/shared/timesheet.service';

@Component({
  selector: 'app-emplogin',
  templateUrl: './emplogin.component.html',
  styleUrls: ['./emplogin.component.css']
})
export class EmploginComponent implements OnInit {
  temp:any;
  constructor(private _timesheetSer:TimesheetService,private _router:Router) { }

  ngOnInit(): void {
  }

  loginUser(val:any){
    // this._empSer.getLoginCredential().subscribe((res)=>{this.empData=res});
    // const data=this.empData.filter((item:any)=>(item.uid==this.uid)&&(item.upass==this.upass));
    // if(data.length>0){
    //   this._empSer.signIn(this.uid);
    //   this._router.navigate(['crud']);
    // }
    // else{
    //   alert("Invalid Credentials!");
    //   this.uid="";
    //   this.upass="";
    // }
    const userObj={email:val.email,password:val.password}
    this._timesheetSer.Login(userObj).subscribe((res)=>{
      this.temp=res;
      if(this.temp!=null)
      {
        this._timesheetSer.signIn(this.temp.empid);
        this._router.navigate(['empdash'])
      }
      else
      {
        alert("Invalid Email/Password");

      }
    })
  }

}


