import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CreatdemandeComponent } from './creatdemande.component';

describe('CreatdemandeComponent', () => {
  let component: CreatdemandeComponent;
  let fixture: ComponentFixture<CreatdemandeComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [CreatdemandeComponent]
    });
    fixture = TestBed.createComponent(CreatdemandeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
