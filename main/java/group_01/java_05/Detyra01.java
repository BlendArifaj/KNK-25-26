package group_01.java_05;

import models.Student;
import models.mappers.ResultSetMapper;
import models.mappers.StudentMapper;
import services.DatabaseService;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Detyra01 {
    public static void main(String[] args){
        // PreparedStatement vs Statement
        int userInputId = 8;

//        String sql = "SELECT * FROM USERS WHERE USERNAME = '" + username +"'";

//        Statement:
//        SELECT * FROM USERS WHERE USERNAME = '' OR 1=1;

//        PreparedStatement
//        SELECT * FROM USERS WHERE USERNAME = "' OR 1 = 1;"
        String preparedSql = "SELECT * FROM students WHERE id = ?";
        Connection conn = DatabaseService.getConnection();
        try{
            PreparedStatement pstm = conn.prepareStatement(preparedSql);
            pstm.setInt(1, userInputId);
//            pstm.setString(2, "Test");
//            pstm.setBoolean(3, true);
            ResultSet res = pstm.executeQuery();
            ResultSetMapper<Student> studentMapper = new StudentMapper();
            while(res.next()){
                Student std = studentMapper.getFromResultSet(res);

                System.out.printf("Id: %d, Name: %s, Age: %d", std.getId(), std.getName(), std.getAge());
            }
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }

    }
}
