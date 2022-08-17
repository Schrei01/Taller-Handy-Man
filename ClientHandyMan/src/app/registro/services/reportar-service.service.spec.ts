import { TestBed } from '@angular/core/testing';

import { ReportarServiceService } from './reportar-service.service';

describe('ReportarServiceService', () => {
  let service: ReportarServiceService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ReportarServiceService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
