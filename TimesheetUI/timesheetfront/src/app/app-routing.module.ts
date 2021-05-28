import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AddEmployeeComponent } from './add-employee/add-employee.component';
import { AdmindashComponent } from './admindash/admindash.component';
import { EditemployeeComponent } from './editemployee/editemployee.component';
import { HomeComponent } from './home/home.component';

const routes: Routes = [
  {path:"",component:HomeComponent},
  {path:"admindash",component:AdmindashComponent},
  {path:"addemployee",component:AddEmployeeComponent},
  {path:"editemp",component:EditemployeeComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
