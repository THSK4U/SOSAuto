import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MecaniciensSideComponent } from './mecaniciens-side.component';

describe('MecaniciensSideComponent', () => {
  let component: MecaniciensSideComponent;
  let fixture: ComponentFixture<MecaniciensSideComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [MecaniciensSideComponent]
    });
    fixture = TestBed.createComponent(MecaniciensSideComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
