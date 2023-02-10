package com.example.springBoot.controller;

import com.example.springBoot.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.springBoot.service.StudentService;

import java.util.List;

@RestController
//@RequestMapping("/students")
public class StudentController {
    @Autowired
    private StudentService service;

    @PostMapping("/addStudent")
    public Student addStudent(@RequestBody Student student){
        return service.saveStudent(student);
    }
    @GetMapping("/students")
    public List<Student> getStudents(){
        return service.getStudents();
    }
    @GetMapping("/student/{id}")
        public Student findStudentById(@PathVariable String id){
            return service.getStudentById(id);
        }
    @GetMapping("/student/{name}")
    public Student findStudentByName(@PathVariable String name){
        return service.getStudentByName(name);
    }
    @PutMapping("/update")
    public Student updateStudent(@PathVariable Student student){
        return service.updateStudent(student);
    }
    @DeleteMapping("/delete/{id}")
    public String deleteStudent(@PathVariable String id){
        return service.deleteStudent(id);
    }

}
