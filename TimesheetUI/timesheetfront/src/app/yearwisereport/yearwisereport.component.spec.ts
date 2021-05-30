import { ComponentFixture, TestBed } from '@angular/core/testing';

import { YearwisereportComponent } from './yearwisereport.component';

describe('YearwisereportComponent', () => {
  let component: YearwisereportComponent;
  let fixture: ComponentFixture<YearwisereportComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ YearwisereportComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(YearwisereportComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
