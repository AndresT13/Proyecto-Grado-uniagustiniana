import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { FormRevisionesComponent } from './form-revisiones.component';

describe('FormRevisionesComponent', () => {
  let component: FormRevisionesComponent;
  let fixture: ComponentFixture<FormRevisionesComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ FormRevisionesComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(FormRevisionesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
