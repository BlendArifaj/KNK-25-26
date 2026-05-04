package services;

import exceptions.InvalidNameException;
import models.Student;
import models.dto.StudentRequestDto;
import models.dto.StudentResponseDto;
import models.mappers.Mapper;
import models.mappers.StudentMapper;
import models.mappers.StudentResponseMapper;
import repository.BaseRepository;
import repository.IRepository;
import repository.StudentRepository;

// repository
// mapper-at
// input: RequestDTO
// output: ResponseDTO
public class StudentService {
    private final IRepository<Student> studentRepository = new StudentRepository();
    private final Mapper<Student> studentMapper = new StudentMapper();
    private final StudentResponseMapper responseMapper = new StudentResponseMapper();

    public StudentResponseDto save(StudentRequestDto studentDto) throws InvalidNameException{
        this.validate(studentDto);
        Student obj = this.studentMapper.fromDto(studentDto);
        Student student = this.studentRepository.create(obj);
        return this.responseMapper.toResponse(student);
    }

    public Student save(StudentRequestDto studentDto, Integer studentId) throws InvalidNameException{
        this.validate(studentDto);
        Student student = this.studentRepository.getById(studentId);
        student = this.studentMapper.fromDto(student, studentDto);
        return this.studentRepository.update(student);
    }

    public boolean delete(int studentId){
        return this.studentRepository.delete(studentId);
    }

    private void validate(StudentRequestDto studentData) throws InvalidNameException{
        String name = studentData.getName();
        if(
                name == null ||name.isEmpty() || name.length() < 10
        ){
            throw new InvalidNameException(studentData.getName());
        }
    }

}
