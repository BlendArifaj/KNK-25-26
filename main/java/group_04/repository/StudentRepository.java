package group_04.repository;

import group_04.mapper.IMapper;
import group_04.mapper.StudentMapper;
import group_04.models.Student;
import services.DatabaseService;

import java.sql.*;

public class StudentRepository extends BaseRepository<Student> {
    private static final IMapper<Student> mapper = new StudentMapper();
    private static final String createQuery = "INSERT INTO student (name, age) VALUES (?, ?)";
    private static final String updateQuery = "UPDATE student SET name = ? and age = ? WHERE id = ?";

    public StudentRepository(){
        super(Student.tableName, mapper, createQuery, updateQuery);
    }

    public void setCreatePreparedStatementPlaceholders(PreparedStatement pstm, Student obj) throws SQLException{
        pstm.setString(1, obj.getName());
        pstm.setInt(2, obj.getAge());
    }
    public void setUpdatePreparedStatementPlaceholders(PreparedStatement pstm, Student obj) throws SQLException{
        pstm.setString(1, obj.getName());
        pstm.setInt(2, obj.getAge());
        pstm.setInt(3, obj.getId());
    }

}
