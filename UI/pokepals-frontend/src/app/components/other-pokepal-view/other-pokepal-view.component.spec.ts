import { ComponentFixture, TestBed } from '@angular/core/testing';

import { OtherPokepalViewComponent } from './other-pokepal-view.component';

describe('OtherPokepalViewComponent', () => {
  let component: OtherPokepalViewComponent;
  let fixture: ComponentFixture<OtherPokepalViewComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ OtherPokepalViewComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(OtherPokepalViewComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
