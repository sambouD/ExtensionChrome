import { TestBed } from '@angular/core/testing';

import { CraConfigServiceService } from './cra-config-service.service';

describe('CraConfigServiceService', () => {
  let service: CraConfigServiceService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(CraConfigServiceService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
