package com.example.librarybackend.service;

import com.example.librarybackend.model.Book;
import com.example.librarybackend.model.CATEGORY;
import com.example.librarybackend.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;
    @Override
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    @Override
    public synchronized void deleteBook(Long id) {
        bookRepository.deleteById(id);
    }

    @Override
    public synchronized void updateCapacity(Long id) {
        Book book = bookRepository.findById(id).get();
        int oldC = book.getAvailableCopies();
        int newC = oldC-1;
        book.setAvailableCopies(newC);
        bookRepository.save(book);
    }

    @Override
    public void updateBook(Long id, int availableCopies, CATEGORY category, String name) {
        Book book = bookRepository.findById(id).get();
        book.setAvailableCopies(availableCopies);
        book.setCategory(category);
        book.setName(name);
        bookRepository.save(book);
    }

}
