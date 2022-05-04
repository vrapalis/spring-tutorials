package com.example.library.service;

import org.springframework.http.ResponseEntity;

public interface LibraryService {
    ResponseEntity<String> greeting();
}
