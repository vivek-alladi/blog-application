package com.example.blogApplication.Controller;


import com.example.blogApplication.Bean.Student;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class StudentController {

//    returning java bean as json
    @GetMapping("student")
    public ResponseEntity<Student> getStudent(){
        Student student = new Student(1,"ravi","kishore");
        //return new ResponseEntity<>(student, HttpStatus.OK);
        //return ResponseEntity.ok(student);
        return ResponseEntity.ok().header("custom-header", "custom-value").body(student);
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

//    http://localhost:8080/students/1/first/last
    @GetMapping("students/{id}/{first-name}/{last-name}")
    public Student studentsPathVariable(@PathVariable("id") int studentId, @PathVariable("first-name") String firstName, @PathVariable("last-name") String lastName){
        return new Student(studentId, firstName, lastName);
    }

//    spring boot rest api with request param(query parameters)
//    http://localhost:8080/students/query?id=1&firstName=ram&lastName=reem
    @GetMapping("students/query")
    public Student studentRequestVariable(@RequestParam int id, @RequestParam String firstName, String lastName){
        return new Student(id, firstName, lastName);
    }

//    rest api that handles post request
    @PostMapping("students/create")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Student> createStudent(@RequestBody Student student){
        System.out.println(student.getId());
        System.out.println(student.getFirstName());
        System.out.println(student.getLastName());
        return new ResponseEntity<>(student, HttpStatus.CREATED);
    }

    // http put request
    @PutMapping("students/{id}/update")
    public Student updateStudent(@RequestBody Student student, @PathVariable("id") int studentId){
        System.out.println(studentId);
        student.setId(10);
        System.out.println(student.getFirstName());
        System.out.println(student.getLastName());
        return student;
    }

    //rest-api delete request
    @DeleteMapping("students/{id}/delete")
    public String deleteStudent(@PathVariable("id") int studentId){
        String message = "student " + studentId + " deleted successfully";
        return message;
    }

}
