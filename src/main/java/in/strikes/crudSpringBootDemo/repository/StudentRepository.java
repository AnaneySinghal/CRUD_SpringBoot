package in.strikes.crudSpringBootDemo.repository;

import in.strikes.crudSpringBootDemo.entity.Student;
import org.springframework.stereotype.Component;

@Component
public class StudentRepository {
    public Student saveStudent(Student studentReq){
// save to db
//        return null;

        Student s1 = new Student();
        s1.setAge(28);
        s1.setEmail("ananey.singhal_cs23@gla.ac.in");
        s1.setRollNo(101);
        s1.setName("Ananey Singhal");
        s1.setSubject("Spring-FrameWork");
        return s1;
    }
}
