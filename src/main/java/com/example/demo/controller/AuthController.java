package com.example.demo.controller;

import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.response.ApiResponse;
import com.example.demo.services.AuthService;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Positive;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@RestController
@RequestMapping("v1/auth/")
public class AuthController {
    private final AuthService authService;
    public AuthController (AuthService authService){
        this.authService=authService;
    }
    private  ApiResponse<?> response ;
    @GetMapping("{id}")
    public ResponseEntity<?> getMethodName() {
        return ResponseEntity.ok("Sopheak");
        }

    @PostMapping("userinfo")
    public ResponseEntity<?> insertInfo(String username,int age,  String gender  ) {
        System.out.println("Data: "+  username);
         response = ApiResponse.builder()
                                .message("Data was upload successfully")
                                .payload(authService.insertUserInfo(username,age,gender))
                                .status(HttpStatus.OK)
                                .statusCode(HttpStatus.OK.value()).build(); 
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
}
