import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MapMotoristComponent } from './map-motorist.component';

describe('MapMotoristComponent', () => {
  let component: MapMotoristComponent;
  let fixture: ComponentFixture<MapMotoristComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [MapMotoristComponent]
    });
    fixture = TestBed.createComponent(MapMotoristComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
