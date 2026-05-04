package models.mappers;

import models.Student;
import models.dto.StudentResponseDto;

import java.util.ArrayList;

public class StudentResponseMapper {
    public StudentResponseDto toResponse(Student student, ArrayList<Integer> grades){
        return new StudentResponseDto(
                student.getId(),
                student.getAge(),
                student.getName(),
                grades
        );
    }

    public StudentResponseDto toResponse(Student student){
        return new StudentResponseDto(
                student.getId(),
                student.getAge(),
                student.getName(),
                new ArrayList<>()
        );
    }
}
