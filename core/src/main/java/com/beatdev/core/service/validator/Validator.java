package com.beatdev.core.service.validator;

public interface Validator<E> {
    boolean isValid(E entity);
}
