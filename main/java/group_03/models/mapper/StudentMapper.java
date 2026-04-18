package group_03.models.mapper;

import group_03.models.Student;

import java.sql.ResultSet;

public class StudentMapper implements Mapper<Student> {
    public Student getFromResultSet(ResultSet res){
        try{
            int id = res.getInt("id");
            String name = res.getString("name");
            int age = res.getInt("age");

            return new Student(id, name, age);
        }catch (Exception e){
            return null;
        }
    }
}
