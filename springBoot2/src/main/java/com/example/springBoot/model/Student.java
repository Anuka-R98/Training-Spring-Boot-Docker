package com.example.springBoot.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data //no need for specify @getter @setters
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "students")
public class Student {

    @Id

    private String id;
    private String name;
    private String date_of_birth;
    private double average;

//    public Student(){
//        this.id = "";
//        this.name = "";
//        this.date_of_birth = "";
//        this.average = 0.0;
//    }
//    public Student(String id, String name, String date_of_birth, double average) {
//        this.id = id;
//        this.name = name;
//        this.date_of_birth = date_of_birth;
//        this.average = average;
//    }

}
