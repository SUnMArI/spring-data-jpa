package com.example.demo.services;
import com.example.demo.model.entity.Student;

public interface AuthService {
    Student insertUserInfo(String usernaem, int age, String gender);
}
