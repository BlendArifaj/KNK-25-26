package models.mappers;

import models.Student;
import models.dto.IRequestDto;
import models.dto.StudentRequestDto;
import models.mappers.Mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class StudentMapper implements Mapper<Student> {
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

    @Override
    public Student fromDto(IRequestDto dto) {
        StudentRequestDto sDto = (StudentRequestDto) dto;
        return new Student(
                0, sDto.getName(), sDto.getAge()
        );
    }

    @Override
    public Student fromDto(Student student, IRequestDto dto){
        StudentRequestDto sDto = (StudentRequestDto) dto;
        student.setName(sDto.getName());
        student.setAge(sDto.getAge());
        return student;
    }
}
