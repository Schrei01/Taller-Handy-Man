package com.handyman.ias.application.ports.input;

import com.handyman.ias.application.services.HoursResult;
import com.handyman.ias.commons.DoubleIntUseCase;

public interface GetHoursUseCase extends DoubleIntUseCase<String, Integer, HoursResult> {
}
