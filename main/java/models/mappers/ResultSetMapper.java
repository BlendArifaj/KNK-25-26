package models.mappers;

import java.sql.ResultSet;

public interface ResultSetMapper<T> {
    T getFromResultSet(ResultSet res);
}
