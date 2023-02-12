package com.example.springBoot.service;

import com.example.springBoot.customExceptions.ResourceNotFoundException;
import com.example.springBoot.model.Student;
import com.example.springBoot.repository.StudentRepository;
import com.example.springBoot.request.StudentRequest;
import com.example.springBoot.response.StudentResponse;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.logging.Logger;

@Service
public class StudentService {
    private static final Logger log = (Logger) LoggerFactory.getLogger(StudentService.class);
    @Autowired
    private StudentRepository studentRepository;
    // Save a student
    public StudentResponse saveStudent(StudentRequest studentRequest){
        Student student = new Student();
        student.setName(studentRequest.getName());
        student.setDate_of_birth(studentRequest.getDate_of_birth());
        student.setAverage(studentRequest.getAverage());

        log.info("Saving student : " + student.getName());
        studentRepository.save(student);

        StudentResponse response = new StudentResponse();
        response.setId(student.getId());
        response.setName(student.getName());
        response.setDate_of_birth(student.getDate_of_birth());
        response.setAverage(student.getAverage());

        return response;
    }

    // Update student
    public StudentResponse updateStudent(String id, StudentRequest studentRequest){
        Student existingStudent = studentRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Student not found with id: " + id));
        existingStudent.setName(studentRequest.getName());
        existingStudent.setDate_of_birth(studentRequest.getDate_of_birth());
        existingStudent.setAverage(studentRequest.getAverage());

        log.info("Updating student : " + existingStudent.getName());
        studentRepository.save(existingStudent);

        return new StudentResponse(existingStudent.getId(), existingStudent.getName(),
                existingStudent.getDate_of_birth(), existingStudent.getAverage());
    }

    // Get all students
    public List<Student> getStudents(){
        log.info("Getting all students");
        return studentRepository.findAll();
    }

    // Get a specific student using student id
    public Student getStudentById(String id){
        log.info("Getting student with id: {}" + id);
        return studentRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Student not found with id:" + id));
    }

    // Get a specific student by student name
    public Student getStudentByName(String name){
        log.info("Getting student with name: {}" + name);
        return studentRepository.findByName(name);
//        .orElseThrow(() -> new ResourceNotFoundException("Student not found with name: " + name))
    }

    // Delete student by student id
    public String deleteStudent(String id){
        log.info("Deleting student with id: {}" + id);
        studentRepository.deleteById(id);
         return "student removed !!" + id;
    }

}
