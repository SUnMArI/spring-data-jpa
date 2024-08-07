package com.example.demo.services.serviceImplement;


import org.springframework.stereotype.Service;

import com.example.demo.model.entity.Student;
import com.example.demo.repository.AuthRepository;
import com.example.demo.services.AuthService;

import jakarta.persistence.EntityManager;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class AuthServiceImp implements AuthService {
    private final AuthRepository repository;
   
    @Override
    public Student insertUserInfo(String usernaem, int age, String gender) {
        Student student  = new Student(usernaem,age,gender);
        // EntityManager em =
        System.out.println("Hello: "+ student);
       repository.save(student);
       return student;
    }
    
}
