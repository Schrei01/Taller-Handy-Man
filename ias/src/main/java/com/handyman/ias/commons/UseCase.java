package com.handyman.ias.commons;

public interface UseCase<I,O> {
    O execute(I i);
}
