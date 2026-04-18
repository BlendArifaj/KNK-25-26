package group_04.mapper;

import group_04.models.dto.IRequestDto;
import group_04.models.dto.StudentRequestDto;

import java.sql.ResultSet;

public interface IMapper<T> {
    T fromResultSet(ResultSet res);
    T fromCreateRequestDto(IRequestDto dto);
    T fromUpdateRequestDto(int id, IRequestDto dto);
}
