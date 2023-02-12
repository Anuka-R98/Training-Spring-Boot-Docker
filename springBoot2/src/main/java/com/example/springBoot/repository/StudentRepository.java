package com.example.springBoot.repository;

import com.example.springBoot.model.Student;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends MongoRepository<Student, String>{
    Student findByName(String name);
}