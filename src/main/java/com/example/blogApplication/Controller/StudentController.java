package com.example.blogApplication.Controller;


import com.example.blogApplication.Bean.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class StudentController {

//    returning java bean as json
    @GetMapping("student")
    public Student getStudent(){
        Student student = new Student(1,"ravi","kishore");
        return student;
    }

//    returning java bean list as json
    @GetMapping("students")
    public List<Student> getStudents(){
        ArrayList<Student> students = new ArrayList<>();
        students.add(new Student(1,"ram","mishra"));
        students.add(new Student(2,"bhim","nayak"));
        return students;
    }

//    Spring boot REST Api with path variable
    @GetMapping("student/{id}")
    public Student studentPathVariable(@PathVariable int id){
        return new Student(id, "ram", "rame");
    }

    @GetMapping("students/{id}")
    public Student studentsPathVariable(@PathVariable("id") int studentId){
        return new Student(studentId, "ram", "ramer");
    }

    @GetMapping("students/{id}/{first-name}/{last-name}")
    public Student studentsPathVariable(@PathVariable("id") int studentId, @PathVariable("first-name") String firstName, @PathVariable("last-name") String lastName){
        return new Student(studentId, firstName, lastName);
    }
}
