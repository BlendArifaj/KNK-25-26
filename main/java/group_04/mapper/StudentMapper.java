package group_04.mapper;

import group_04.models.Student;
import group_04.models.dto.IRequestDto;
import group_04.models.dto.StudentRequestDto;

import java.sql.ResultSet;


// SceneBuilder
public class StudentMapper implements IMapper<Student> {
    @Override
    public Student fromResultSet(ResultSet res) {
        try{
            int id = res.getInt("id");
            String name = res.getString("name");
            int age = res.getInt("age");

            return new Student(id, name, age);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

        return null;
    }

    @Override
    public Student fromCreateRequestDto(IRequestDto dto) {
        StudentRequestDto studentDto = (StudentRequestDto) dto;
        return new Student(null, studentDto.getName(), studentDto.getAge());
    }

    @Override
    public Student fromUpdateRequestDto(int id, IRequestDto dto) {
        StudentRequestDto studentDto = (StudentRequestDto) dto;
        return new Student(id, studentDto.getName(), studentDto.getAge());
    }
}
