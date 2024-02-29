import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CraFormComponent } from './cra-form.component';

describe('CraFormComponent', () => {
  let component: CraFormComponent;
  let fixture: ComponentFixture<CraFormComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [CraFormComponent]
    });
    fixture = TestBed.createComponent(CraFormComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
