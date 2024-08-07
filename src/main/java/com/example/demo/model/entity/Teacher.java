package com.example.demo.model.entity;

import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "teachers")
public class Teacher {
    @Id
    @GeneratedValue( strategy =GenerationType.UUID  )
    private UUID teacher_id;
    @Column(name = "th_name")
    private String name;
    @Column(name = "th_age")
    private int age;

    
}
