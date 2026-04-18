package group_03.java_05;

import group_03.models.Student;
import group_03.models.mapper.Mapper;
import group_03.models.mapper.StudentMapper;
import services.DatabaseService;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Detyra01 {
    public static void main(String[] args){
        Connection conn = DatabaseService.getConnection();
        String username = "' OR 1 = 1; ";
        int userInputId = 5;
        String query = "SELECT * FROM students where username = '' OR 1 = 1;";
        String query2 = "SELECT * FROM students where id = ?";
        // SELECT * FROM students where username = "' OR 1 = 1; "

        Mapper<Student> mapper = new StudentMapper();
        try{
            PreparedStatement pstm = conn.prepareStatement(query2);
            pstm.setInt(1, userInputId);

            ResultSet res = pstm.executeQuery();
            while(res.next()){
                Student student = mapper.getFromResultSet(res);

                System.out.printf("Id: %d, Name: %s, Age: %d",
                        student.getId(),
                        student.getName(),
                        student.getAge()
                );
            }
            pstm.close();
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }


    }
}
