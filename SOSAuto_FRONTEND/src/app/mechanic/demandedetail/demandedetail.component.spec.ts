import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DemandedetailComponent } from './demandedetail.component';

describe('DemandedetailComponent', () => {
  let component: DemandedetailComponent;
  let fixture: ComponentFixture<DemandedetailComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [DemandedetailComponent]
    });
    fixture = TestBed.createComponent(DemandedetailComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
