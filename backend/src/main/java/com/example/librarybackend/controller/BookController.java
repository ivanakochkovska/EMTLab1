package com.example.librarybackend.controller;

import com.example.librarybackend.model.Book;
import com.example.librarybackend.model.CATEGORY;
import com.example.librarybackend.repository.BookRepository;
import com.example.librarybackend.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class BookController {
    private final BookService bookService;
    private final BookRepository bookRepository;

    @GetMapping("/books")
    public ResponseEntity<List<Book>> getAllBooks() {
        return ResponseEntity.ok(bookService.getAllBooks());
    }

    @DeleteMapping(value = "/book/{id}")
    public ResponseEntity deleteBook(@PathVariable Long id) {
        bookService.deleteBook(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping(value="book/{id}")
    public ResponseEntity updateCapacity(@PathVariable Long id) {
        bookService.updateCapacity(id);
        return ResponseEntity.ok().build();
    }

    @PostMapping(value = "/update/{id}")
    public ResponseEntity updateBook(@PathVariable Long id,
                               @RequestParam Integer availableCopies,
                               @RequestParam String category,
                               @RequestParam String name) {
        CATEGORY category1 = CATEGORY.valueOf(category);
        bookService.updateBook(id, availableCopies, category1, name);
        return ResponseEntity.ok().build();
    }
//    @PostMapping(value = "/newBook")
//    public ResponseEntity addNewBook(
//                                     @RequestParam Integer availableCopies,
//                                     @RequestParam String category,
//                                     @RequestParam String name) {
//        CATEGORY category1 = CATEGORY.valueOf(category);
//        bookService.updateBook(id, availableCopies, category1, name);
//        return ResponseEntity.ok().build();
//    }


}
