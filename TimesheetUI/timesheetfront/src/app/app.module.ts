import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { AdmindashComponent } from './admindash/admindash.component';
import { HeaderComponent } from './header/header.component';
import { HomeComponent } from './home/home.component';
import { Ng2SearchPipeModule } from 'ng2-search-filter';
import { NgxPaginationModule } from 'ngx-pagination';
import { FormsModule } from '@angular/forms';
import { ModalModule } from 'ngx-bootstrap/modal';
import { HttpClientModule } from '@angular/common/http';
import { AddEmployeeComponent } from './add-employee/add-employee.component';
import { EditemployeeComponent } from './editemployee/editemployee.component';
import { AdminloginComponent } from './adminlogin/adminlogin.component';
import { CustomtimesheetreportComponent } from './customtimesheetreport/customtimesheetreport.component';
import { CreateleaveComponent } from './createleave/createleave.component';
import { EmploginComponent } from './emplogin/emplogin.component';
import { EmpdashComponent } from './empdash/empdash.component';
import { EmpupdateComponent } from './empupdate/empupdate.component';
import { ChangepassComponent } from './changepass/changepass.component';
import { AddtimesheetComponent } from './addtimesheet/addtimesheet.component';
import { TimesheetdashComponent } from './timesheetdash/timesheetdash.component';
import { UpdatetimesheetComponent } from './updatetimesheet/updatetimesheet.component';
import { LeaveapplicationComponent } from './leaveapplication/leaveapplication.component';
import { LeavereportComponent } from './leavereport/leavereport.component';
import { MonthwisereportComponent } from './monthwisereport/monthwisereport.component';

@NgModule({
  declarations: [
    AppComponent,
    AdmindashComponent,
    HeaderComponent,
    HomeComponent,
    AddEmployeeComponent,
    EditemployeeComponent,
    AdminloginComponent,
    CustomtimesheetreportComponent,
    CreateleaveComponent,
    EmploginComponent,
    EmpdashComponent,
    EmpupdateComponent,
    ChangepassComponent,
    AddtimesheetComponent,
    TimesheetdashComponent,
    UpdatetimesheetComponent,
    LeaveapplicationComponent,
    LeavereportComponent,
    MonthwisereportComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    Ng2SearchPipeModule,
    NgxPaginationModule,
    FormsModule,
    HttpClientModule,
    ModalModule.forRoot(),
    

  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
