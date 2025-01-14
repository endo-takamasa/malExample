import { ComponentFixture, TestBed } from '@angular/core/testing';

import { UserSetComponent } from './user-set.component';

describe('UserSetComponent', () => {
  let component: UserSetComponent;
  let fixture: ComponentFixture<UserSetComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [UserSetComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(UserSetComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
