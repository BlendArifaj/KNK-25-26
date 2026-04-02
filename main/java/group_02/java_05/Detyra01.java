package group_02.java_05;

import group_02.models.Student;
import group_02.models.mappers.Mapper;
import group_02.models.mappers.StudentMapper;
import services.DatabaseService;

import java.sql.*;

public class Detyra01 {
    public static void main(String[] args){
        Connection connection = DatabaseService.getConnection();

        String password = "' OR 1 = 1";
//        String query = "Select * from users where username = " + username + " AND password = '" + password;

//        String query2 = "Select * from users where username = ? AND password = '/' OR 1 = 1' ";

        int userInput = 5;
        String query3 = "SELECT * FROM students where id = ?";
        Mapper<Student> mapper = new StudentMapper();
        try{
            PreparedStatement pstm = connection.prepareStatement(query3);
            pstm.setInt(1, userInput);
//            pstm.setBoolean(2, false);
//            pstm.setString(3, "String");
            ResultSet res = pstm.executeQuery();
            while(res.next()){
                Student student = mapper.getFromResultSet(res);
                System.out.printf("Id: %d, Name: %s, Age: %d \n",
                        student.getId(),
                        student.getName(),
                        student.getAge());
            }

        }catch (SQLException e){

        }

    }
}
