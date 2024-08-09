package com.example.demo.model.request;

import java.time.LocalDateTime;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class BookRequest {

    private String title;
    private String description;
    private String author;
    private LocalDateTime publicationYear;
}
