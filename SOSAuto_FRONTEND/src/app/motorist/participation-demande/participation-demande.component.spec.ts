import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ParticipationDemandeComponent } from './participation-demande.component';

describe('ParticipationDemandeComponent', () => {
  let component: ParticipationDemandeComponent;
  let fixture: ComponentFixture<ParticipationDemandeComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [ParticipationDemandeComponent]
    });
    fixture = TestBed.createComponent(ParticipationDemandeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
