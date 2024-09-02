import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MotoristComponent } from './motorist.component';

describe('MotoristComponent', () => {
  let component: MotoristComponent;
  let fixture: ComponentFixture<MotoristComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [MotoristComponent]
    });
    fixture = TestBed.createComponent(MotoristComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
