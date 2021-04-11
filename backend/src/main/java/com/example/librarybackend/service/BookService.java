package com.example.librarybackend.service;

import com.example.librarybackend.model.Book;
import com.example.librarybackend.model.CATEGORY;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BookService {
    List<Book> getAllBooks();
    void deleteBook(Long id);
    void updateCapacity(Long id);
    void updateBook(Long id, int availableCopies, CATEGORY category, String name);
}
