import { ComponentFixture, TestBed } from '@angular/core/testing';

import { GesMotoristComponent } from './ges-motorist.component';

describe('GesMotoristComponent', () => {
  let component: GesMotoristComponent;
  let fixture: ComponentFixture<GesMotoristComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [GesMotoristComponent]
    });
    fixture = TestBed.createComponent(GesMotoristComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
