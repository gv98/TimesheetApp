import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {

  constructor(public _router:Router) { }

  ngOnInit(): void {
  }

  signout()
  {
    if(confirm("Are You Sure?"))
    {
      sessionStorage.removeItem("admin");
    this._router.navigate(['home']);
    }
    
  }

}
