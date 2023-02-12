package com.example.springBoot.controller;

import com.example.springBoot.customExceptions.ResourceNotFoundException;
import com.example.springBoot.model.Student;
import com.example.springBoot.request.StudentRequest;
import com.example.springBoot.response.StudentResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.springBoot.service.StudentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;


@RestController
//@RequestMapping("/students")
public class StudentController {
    private static final Logger log = LoggerFactory.getLogger(StudentController.class);
    @Autowired
    private StudentService service;

    @PostMapping("/students")
    public StudentResponse addStudent(@RequestBody StudentRequest studentRequest) {
        try {
            return service.saveStudent(studentRequest);
        } catch (Exception e) {
            // Log the error and return an error response
            log.error("Error while saving student: ", e);
            return new StudentResponse("Error while saving student");
        }
    }
    @GetMapping("/students")
    public ResponseEntity<List<Student>> getStudents(){
        List<Student> students = service.getStudents();
        return new ResponseEntity<>(students, HttpStatus.OK);
    }
    @GetMapping("/students/{id}")
    public ResponseEntity<Student> findStudentById(@PathVariable String id){
        try{
            Student student = service.getStudentById(id);
            return new ResponseEntity<>(student, HttpStatus.OK);
        }catch(ResourceNotFoundException e){
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping("/students/{name}")
    public ResponseEntity<Student> findStudentByName(@PathVariable String name){
        try{
            Student student = service.getStudentByName(name);
            return new ResponseEntity<>(student, HttpStatus.OK);
        }catch(ResourceNotFoundException e){
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }
    @PutMapping("/students/{id}")
    public ResponseEntity<StudentResponse> updateStudent(@PathVariable String id, @RequestBody StudentRequest studentRequest){
        try{
            StudentResponse studentResponse = service.updateStudent(id, studentRequest);
            return new ResponseEntity<>(studentResponse, HttpStatus.OK);
        }catch(ResourceNotFoundException e){
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }
    @DeleteMapping("/students/{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable String id){
        try{
            String response = service.deleteStudent(id);
            return new ResponseEntity<>(response, HttpStatus.OK);
        }catch (ResourceNotFoundException e){
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }
//    @DeleteMapping("/students/{id}")
//    public String deleteStudent(@PathVariable String id){
//        try{
//            return service.deleteStudent(id);
//        }catch (Exception e){
//            throw new ResourceNotFoundException("Error Deleting Student"+ e.getMessage());
//        }
//    }

}
