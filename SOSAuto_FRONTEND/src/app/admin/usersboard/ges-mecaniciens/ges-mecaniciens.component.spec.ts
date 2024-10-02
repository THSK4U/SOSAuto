import { ComponentFixture, TestBed } from '@angular/core/testing';

import { GesMecaniciensComponent } from './ges-mecaniciens.component';

describe('GesMecaniciensComponent', () => {
  let component: GesMecaniciensComponent;
  let fixture: ComponentFixture<GesMecaniciensComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [GesMecaniciensComponent]
    });
    fixture = TestBed.createComponent(GesMecaniciensComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
