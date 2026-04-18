package group_03.models.mapper;

import java.sql.ResultSet;
import java.util.HashMap;

public interface Mapper<T> {
    T getFromResultSet(ResultSet res);

//    T getFromHashMap(HashMap<String, String> map);
}
