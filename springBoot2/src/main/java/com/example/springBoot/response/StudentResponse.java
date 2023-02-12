package com.example.springBoot.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentResponse {
    private String Id;
    private String name;
    private String date_of_birth;
    private double average;

    public StudentResponse(String errorWhileSavingStudent) {
    }

//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public String getDate_of_birth() {
//        return date_of_birth;
//    }
//
//    public void setDate_of_birth(String date_of_birth) {
//        this.date_of_birth = date_of_birth;
//    }
//
//    public double getAverage() {
//        return average;
//    }
//
//    public void setAverage(double average) {
//        this.average = average;
//    }
}
