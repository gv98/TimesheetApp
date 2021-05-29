import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AddEmployeeComponent } from './add-employee/add-employee.component';
import { AdmindashComponent } from './admindash/admindash.component';
import { AdminloginComponent } from './adminlogin/adminlogin.component';
import { ChangepassComponent } from './changepass/changepass.component';
import { CreateleaveComponent } from './createleave/createleave.component';
import { CustomtimesheetreportComponent } from './customtimesheetreport/customtimesheetreport.component';
import { EditemployeeComponent } from './editemployee/editemployee.component';
import { EmpdashComponent } from './empdash/empdash.component';
import { EmploginComponent } from './emplogin/emplogin.component';
import { EmpupdateComponent } from './empupdate/empupdate.component';
import { HomeComponent } from './home/home.component';

const routes: Routes = [
  {path:"",component:HomeComponent},
  {path:"home",component:HomeComponent},
  {path:"admindash",component:AdmindashComponent},
  {path:"addemployee",component:AddEmployeeComponent},
  {path:"editemp",component:EditemployeeComponent},
  {path:"adminlogin",component:AdminloginComponent},
  {path:"customtimesheetreport",component:CustomtimesheetreportComponent},
  {path:"createleave",component:CreateleaveComponent},
  {path:"emplogin",component:EmploginComponent},
  {path:"empdash",component:EmpdashComponent},
  {path:"empupdate",component:EmpupdateComponent},
  {path:"changepass",component:ChangepassComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
