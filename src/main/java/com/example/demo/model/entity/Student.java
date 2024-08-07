package com.example.demo.model.entity;

import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="students")
public class Student {
    @Id
    @GeneratedValue(strategy=GenerationType.UUID)
    @Column(name = "student_id")
    private UUID studentId;
    @Column(name="st_name", length=50, nullable=false, unique=false)
    private String name;
    @Column(name = "st_age")
    private int age ;
    @Column(name = "st_gender")
    private String gender;

    public Student(String name,int age, String gender){
        this.name = name;
        this.age = age;
        this.gender = gender;
    }
}