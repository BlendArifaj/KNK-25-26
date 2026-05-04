package repository;

import models.User;
import models.mappers.Mapper;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UserRepository extends BaseRepository<User> {

    @Override
    String getInsertQuery() {
        return "INSERT INTO user (username, salt, saltedHash) VALUES (?, ?, ?)";
    }

    @Override
    String getUpdateQuery() {
        return "UPDATE user SET username = ?, salt = ?, saltedHash = ? WHERE id = ?";
    }

    @Override
    Mapper<User> getMapper() {
        return null;
    }

    @Override
    String tableName() {
        return "user";
    }

    @Override
    void setPstmCreate(PreparedStatement pstm, User obj) throws SQLException {
        pstm.setString(1, obj.getUsername());
        pstm.setString(2, obj.getSalt());
        pstm.setString(3, obj.getSaltedHash());
    }

    @Override
    void setPstmUpdate(PreparedStatement pstm, User obj) throws SQLException {
        pstm.setString(1, obj.getUsername());
        pstm.setString(2, obj.getSalt());
        pstm.setString(3, obj.getSaltedHash());
        pstm.setInt(4, obj.getId());
    }

    @Override
    public boolean delete(User obj) {
        return this.delete(obj.getId());
    }

    public User getByUsername(String username){
        return null; // TODO: implement this
    }
}
