package com.handyman.ias.commons;

public interface DoubleIntUseCase<I,I2,O> {
    O execute(I i, I2 i2);
}
