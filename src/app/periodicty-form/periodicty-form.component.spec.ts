import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PeriodictyFormComponent } from './periodicty-form.component';

describe('PeriodictyFormComponent', () => {
  let component: PeriodictyFormComponent;
  let fixture: ComponentFixture<PeriodictyFormComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [PeriodictyFormComponent]
    });
    fixture = TestBed.createComponent(PeriodictyFormComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
