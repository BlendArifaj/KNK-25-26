package models.mappers;

import models.User;
import models.dto.IRequestDto;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserMapper implements Mapper<User> {
    @Override
    public User getFromResultSet(ResultSet res) {
        try{
            int id = res.getInt("id");
            String username = res.getString("username");
            String salt = res.getString("salt");
            String saltedHash = res.getString("salted_hash");
            return new User(id, username, salt, saltedHash);
        }catch (SQLException e){
            return null;
        }
    }

    @Override
    public User fromDto(IRequestDto dto) {
        return null;
    }

    @Override
    public User fromDto(User obj, IRequestDto dto) {
        return null;
    }
}
