package group_02.models.mappers;

import java.sql.ResultSet;

public interface Mapper <T>{
    T getFromResultSet(ResultSet res);
}
