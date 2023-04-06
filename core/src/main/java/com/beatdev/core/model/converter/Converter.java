package com.beatdev.core.model.converter;

public interface Converter<E, D> {
    E convertToEntity(D dto);
    D converToDto(E entity);
}
