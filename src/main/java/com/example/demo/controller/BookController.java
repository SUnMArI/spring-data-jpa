package com.example.demo.controller;

import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.entity.Book;
import com.example.demo.model.request.BookRequest;
import com.example.demo.model.response.ApiResponse;
import com.example.demo.repository.BookRepository;


import lombok.AllArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;


@RestController
@RequestMapping("/v1/book")
@AllArgsConstructor
public class BookController {
    
    private final BookRepository bookRepository;

    @PostMapping
    public ResponseEntity<?> insertInfo(@RequestBody BookRequest bookRequest) {
        // Convert BookRequest to Book entity
        Book book = new Book();
        book.setId(null);
        book.setTitle(bookRequest.getTitle());
        book.setDescription(bookRequest.getDescription());
        book.setAuthor(bookRequest.getAuthor());
        book.setPublicationYear(bookRequest.getPublicationYear());

        // book.setId(null);
        // book.setTitle("Heng");
        // book.setDescription("Heng");
        // book.setAuthor("Heng");
        // book.setPublicationYear(LocalDateTime.now());

        // Insert the book into the repository
        Book insertedBook = bookRepository.insertBook(book);

        // Build the API response
        ApiResponse<Book> response = ApiResponse.<Book>builder()
                                .message("Insert book successfully")
                                .payload(insertedBook)
                                .status(HttpStatus.OK)
                                .build();

        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @GetMapping("")
    public ResponseEntity<?> getAllBook() {
        ApiResponse<?> response  = ApiResponse.builder()
        .message("Insert all books successfully")
        .payload(bookRepository.selectAllBooks())
        .build();
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @GetMapping("{id}")
    public ResponseEntity<?> getBookById(@PathVariable UUID id) {
        ApiResponse<?> response  = ApiResponse.builder()
        .message("Insert book by id successfully")
        .payload(bookRepository.selectBookById(id))
        .build();
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @GetMapping("{title}")
    public ResponseEntity<?> getBookByTitleEntity(@RequestBody String title) {
        ApiResponse<?> response  = ApiResponse.builder()
        .message("get book by title successfully")
        .payload(bookRepository.selectBookByTitle(title))
        .build();
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @PutMapping("")
    public ResponseEntity<?> updateBookById(@RequestBody Book book  ) {
        
        ApiResponse<?> response  = ApiResponse.builder()
                                .message("Updated book successfully")
                                .payload(bookRepository.updateBookById(book))
                                .build();

        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> deleteBookById(@PathVariable UUID id) {
        ApiResponse<?> response  = ApiResponse.builder()
        .message("Deleted book successfully")
        .payload(bookRepository.deleteBookById(id))
        .build();
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
    

}
