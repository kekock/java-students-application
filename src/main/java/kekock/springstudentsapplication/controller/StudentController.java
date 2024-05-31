package kekock.springstudentsapplication.controller;

import kekock.springstudentsapplication.entity.Student;
import kekock.springstudentsapplication.service.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/all_students")
@AllArgsConstructor
public class StudentController {

    private StudentService firstService;

    @GetMapping
    public List<Student> findAllStudents(){
        return firstService.findAllStudents();
    }

    @PostMapping("/save_student")
    public String saveStudent(@RequestBody Student student){
        firstService.saveStudent(student);
        return "Student successfully saved";
    }

    @GetMapping("/{email}")
    public Student findByEmail(@PathVariable String email){
        return firstService.findByEmail(email);
    }

    @PutMapping("/update_student")
    public Student updateStudent(@RequestBody Student student){
        return firstService.updateStudent(student);
    }

    @DeleteMapping("/delete_student/{email}")
    public void deleteStudent(@PathVariable String email){
        firstService.deleteStudent(email);
    }
}