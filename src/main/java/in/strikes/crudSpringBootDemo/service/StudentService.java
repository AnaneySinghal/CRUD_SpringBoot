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
        studentReq.setDeleted(false);
        Student studentResp=studentRepository.save(studentReq);
        return studentResp;
    }

    public Student getStudent(Long id){
       Optional<Student> studentResp= studentRepository.findByIdAndDeletedIsFalse(id);

       if(studentResp.isPresent()){
           return studentResp.get();
       }
       return null;

    }
    public List<Student> getAllStudent(){
        List<Student> studentList= studentRepository.findByDeletedIsFalse();
        return studentList;

    }

    public Student updateStudent(Long id, Student studentReq){
       Optional<Student> existingStudent=studentRepository.findByIdAndDeletedIsFalse(id);

       if(existingStudent.isEmpty()){
           return null;
       }
       Student studentToSave=existingStudent.get();

       studentToSave.setName(studentReq.getName());
       studentToSave.setSubject(studentReq.getSubject());
       studentToSave.setRollNo(studentReq.getRollNo());
       studentToSave.setAge(studentReq.getAge());
       studentToSave.setEmail(studentReq.getEmail());

       studentToSave.setDeleted(false);
       return studentRepository.save(studentToSave);
    }

    public boolean deleteStudent(Long id){
        Boolean isStudent =studentRepository.existsById(id);

        if(!isStudent) return  false;
        studentRepository.deleteById(id);
        return true;

    }

    public boolean deleteStudentSoftly(Long id){
        Optional<Student>existingStudent=studentRepository.findByIdAndDeletedIsFalse(id);
        if(existingStudent.isEmpty()){
            return  false;
        }
        Student studentToSave=existingStudent.get();
        studentToSave.setDeleted(true);
        studentRepository.save(studentToSave);
        return true;

    }
}
