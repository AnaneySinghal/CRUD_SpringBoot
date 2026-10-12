package in.strikes.crudSpringBootDemo.service;

import in.strikes.crudSpringBootDemo.entity.Student;
import in.strikes.crudSpringBootDemo.repository.StudentRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import static in.strikes.crudSpringBootDemo.repository.StudentRepository.*;

// validations perfomerd here
//business logic
// store to db
@Service
public class StudentService {
    private StudentRepository studentRepository;
    public StudentService(StudentRepository studentRepository){
        this.studentRepository=studentRepository;
    }
    public Student createStudent(Student studentReq){
        Student studentResp=studentRepository.saveStudent(studentReq);
        return studentResp;
    }
}
