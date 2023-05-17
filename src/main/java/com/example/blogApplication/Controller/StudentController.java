package com.example.blogApplication.Controller;


import com.example.blogApplication.Bean.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class StudentController {

    @GetMapping("student")
    public Student getStudent(){
        Student student = new Student(1,"ravi","kishore");
        return student;
    }

    @GetMapping("students")
    public List<Student> getStudents(){
        ArrayList<Student> students = new ArrayList<>();
        students.add(new Student(1,"ram","mishra"));
        students.add(new Student(2,"bhim","nayak"));
        return students;
    }
}
