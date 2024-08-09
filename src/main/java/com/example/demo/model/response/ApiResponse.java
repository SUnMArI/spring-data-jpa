package com.example.demo.model.response;

import java.sql.Date;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@AllArgsConstructor
@Data
@Builder
public class ApiResponse<T> {
    private String message;
    private T payload ;
    private HttpStatus status;
}
