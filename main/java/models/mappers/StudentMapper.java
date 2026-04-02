package models.mappers;

import models.Student;

import java.sql.ResultSet;
import java.sql.SQLException;

public class StudentMapper implements ResultSetMapper<Student>{
    public Student getFromResultSet(ResultSet res){
        try{
            int id = res.getInt("id");
            String name = res.getString("name");
            int age = res.getInt("age");

            return new Student(id, name, age);
        }catch (SQLException e){
           System.out.println(e.getMessage());
           return null;
        }
    }
}
