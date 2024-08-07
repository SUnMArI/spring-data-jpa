package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.entity.Student;

public interface AuthRepository extends JpaRepository<Student, Integer> {
    
}
