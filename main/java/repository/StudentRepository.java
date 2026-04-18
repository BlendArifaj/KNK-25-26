package repository;

import models.Student;
import models.mappers.Mapper;
import models.mappers.StudentMapper;
import services.DatabaseService;

import java.sql.*;

public class StudentRepository extends BaseRepository<Student> {
//    select, create, update, delete
    @Override
    String tableName() {
        return "student";
    }

    @Override
    Mapper<Student> getMapper() {
        return new StudentMapper();
    }

    public String getInsertQuery(){
        return  "INSERT INTO student (name, age) VALUES (?, ?)";
    }

    public String getUpdateQuery(){
        return "UPDATE student SET name = ? and age = ? WHERE id = ?";
    }

    public void setPstmCreate(PreparedStatement pstm, Student student) throws SQLException {
        pstm.setString(1, student.getName());
        pstm.setInt(2, student.getAge());
    }

    public void setPstmUpdate(PreparedStatement pstm, Student student) throws SQLException {
        pstm.setString(1, student.getName());
        pstm.setInt(2, student.getAge());
        pstm.setInt(3, student.getId());

    }

    public boolean delete(Student student){
        return delete(student.getId());
    }
}
