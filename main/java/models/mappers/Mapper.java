package models.mappers;

import models.dto.IRequestDto;

import java.sql.ResultSet;

public interface Mapper<T> {
    T getFromResultSet(ResultSet res);
    T fromDto(IRequestDto dto);
    T fromDto(T obj, IRequestDto dto);
}
