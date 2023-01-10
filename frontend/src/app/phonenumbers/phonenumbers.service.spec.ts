import { TestBed } from '@angular/core/testing';

import { PhonenumbersService } from './phonenumbers.service';

describe('PhonenumbersService', () => {
  let service: PhonenumbersService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(PhonenumbersService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
