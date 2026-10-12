package in.strikes.crudSpringBootDemo.controller;


import in.strikes.crudSpringBootDemo.entity.Student;
import in.strikes.crudSpringBootDemo.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentController {

  private StudentService studentService;

  public StudentController(StudentService studentService){
      this.studentService=studentService;
  }

//    @PostMapping
//    public Student createStudent(@RequestBody Student student){
//        System.out.println("Inside student controller");
//      Student createdStudent= studentService.createStudent(student);
//        System.out.println("Exit student controller");
//      return createdStudent;
//    }
    @PostMapping
    public ResponseEntity<Student> createStudent(@RequestBody Student student){
    Student createdStudent= studentService.createStudent(student);
    return ResponseEntity
            .status(HttpStatus.CREATED)
            .body(createdStudent);
}
@GetMapping("/{id}")
public ResponseEntity<Student> getStudent(@PathVariable Long id){
     Student studentResp= studentService.getStudent(id);

     if(studentResp==null){
       return  ResponseEntity.notFound().build();
     }
     return ResponseEntity.ok(studentResp);

}

    @GetMapping()
    public ResponseEntity<List<Student>> getAllStudent(){
        List studentList= studentService.getAllStudent();

        if(studentList.isEmpty()){
            return  ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(studentList);

    }

    @PutMapping("/{id}")
    public ResponseEntity<Student> updateStudent(@PathVariable Long id, @RequestBody Student studentReq){
      Student studentResp=studentService.updateStudent(id,studentReq);

        if(studentResp==null){
            return  ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(studentResp);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable Long id){
      Boolean isDeleted =studentService.deleteStudent(id);

      if(!isDeleted){
          return ResponseEntity.notFound().build();
      }
      return ResponseEntity.ok("Student Deleted");
    }

    @PatchMapping("/{id}")
    public ResponseEntity<String> deleteStudentSoftly(@PathVariable Long id){
      Boolean isDeleted =studentService.deleteStudentSoftly(id);

      if(!isDeleted){
          return ResponseEntity.notFound().build();
      }
      return ResponseEntity.ok("Record Deleted");
    }

}
