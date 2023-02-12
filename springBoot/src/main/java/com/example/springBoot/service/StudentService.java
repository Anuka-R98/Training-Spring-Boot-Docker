package com.example.springBoot.service;

import com.example.springBoot.model.Student;
import com.example.springBoot.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;
    // Save a student
    public Student saveStudent(Student student){
        return studentRepository.save(student);
    }
    // Save list of students
//    public List<Student> saveStudents(List<Student> students){
//        return repository.saveAll(students);
//    }
    // Get all students
    public List<Student> getStudents(){
        return studentRepository.findAll();
    }
    // Get a specific student using student id
    public Student getStudentById(String id){
        return studentRepository.findById(id).orElse(null);
    }
    // Get a specific student by student name
    public Student getStudentByName(String name){
        return studentRepository.findByName(name);
    }
    // Delete student by student id
    public String deleteStudent(String id){
        studentRepository.deleteById(id);
         return "student removed !!" + id;
    }
    // Update student
    public Student updateStudent(Student student){
        Student existingStudent = studentRepository.findById(student.getId()).orElse(null);
        existingStudent.setName(student.getName());
        existingStudent.setDate_of_birth(student.getDate_of_birth());
        existingStudent.setAverage(student.getAverage());

        return studentRepository.save(existingStudent);
    }
}
