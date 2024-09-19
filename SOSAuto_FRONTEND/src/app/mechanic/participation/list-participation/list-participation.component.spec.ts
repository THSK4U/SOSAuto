import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ListParticipationComponent } from './list-participation.component';

describe('ListParticipationComponent', () => {
  let component: ListParticipationComponent;
  let fixture: ComponentFixture<ListParticipationComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [ListParticipationComponent]
    });
    fixture = TestBed.createComponent(ListParticipationComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
