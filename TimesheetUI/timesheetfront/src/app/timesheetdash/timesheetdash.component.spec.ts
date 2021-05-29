import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TimesheetdashComponent } from './timesheetdash.component';

describe('TimesheetdashComponent', () => {
  let component: TimesheetdashComponent;
  let fixture: ComponentFixture<TimesheetdashComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ TimesheetdashComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(TimesheetdashComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
