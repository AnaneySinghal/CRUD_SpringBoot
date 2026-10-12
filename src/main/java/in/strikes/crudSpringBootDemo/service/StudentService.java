package in.strikes.crudSpringBootDemo.service;

import in.strikes.crudSpringBootDemo.entity.Student;
import in.strikes.crudSpringBootDemo.repository.StudentRepository;
import org.springframework.data.convert.ReadingConverter;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

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
        Student studentResp=studentRepository.save(studentReq);
        return studentResp;
    }

    public Student getStudent(Long id){
       Optional<Student> studentResp= studentRepository.findById(id);

       if(studentResp.isPresent()){
           return studentResp.get();
       }
       return null;

    }
    public List<Student> getAllStudent(){
        List<Student> studentList= studentRepository.findAll();
        return studentList;

    }

    public Student updateStudent(Long id, Student studentReq){
       Optional<Student> existingStudent=studentRepository.findById(id);

       if(existingStudent.isEmpty()){
           return null;
       }
       Student studentToSave=existingStudent.get();

       studentToSave.setName(studentReq.getName());
       studentToSave.setSubject(studentReq.getSubject());
       studentToSave.setRollNo(studentReq.getRollNo());
       studentToSave.setAge(studentReq.getAge());
       studentToSave.setEmail(studentReq.getEmail());

       return studentRepository.save(studentToSave);
    }

    public boolean deleteStudent(Long id){
        Boolean isStudent =studentRepository.existsById(id);

        if(!isStudent) return  false;

        studentRepository.deleteById(id);
        return true;

    }
}
