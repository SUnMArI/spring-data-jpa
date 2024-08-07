package com.example.demo.model.response;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class UserInfoResponse {
    private String username;
    private int age;
    private String gender;
}
