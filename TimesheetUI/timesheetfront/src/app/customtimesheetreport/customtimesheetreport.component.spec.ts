import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CustomtimesheetreportComponent } from './customtimesheetreport.component';

describe('CustomtimesheetreportComponent', () => {
  let component: CustomtimesheetreportComponent;
  let fixture: ComponentFixture<CustomtimesheetreportComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CustomtimesheetreportComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(CustomtimesheetreportComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
