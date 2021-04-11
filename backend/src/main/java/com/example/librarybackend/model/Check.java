package com.example.librarybackend.model;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Check {
    @GetMapping("/test")
    public ResponseEntity<String> test() {
        return ResponseEntity.ok("OKEJ");
    }
}
