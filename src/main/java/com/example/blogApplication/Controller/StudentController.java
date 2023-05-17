package com.example.blogApplication.Controller;


import com.example.blogApplication.Bean.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {

    @GetMapping("student")
    public Student getStudent(){
        Student student = new Student(1,"ravi","kishore");
        return student;
    }

}
