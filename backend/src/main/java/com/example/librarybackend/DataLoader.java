package com.example.librarybackend;

import com.example.librarybackend.model.Book;
import com.example.librarybackend.model.CATEGORY;
import com.example.librarybackend.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class DataLoader {
    private final BookRepository bookRepository;

    @GetMapping("/add")
    private ResponseEntity loadUsers() {
        Book book = new Book();
        book.setCategory(CATEGORY.BIOGRAPHY);
        book.setName("jsjkjk");
        book.setAvailableCopies(5);
        bookRepository.save(book);
        List<Book> b = new ArrayList<>();
        for(int i=0;i<6; i++) {
            b.add(book);
        }
        bookRepository.saveAll(b);
       return ResponseEntity.ok().build();


    }
}