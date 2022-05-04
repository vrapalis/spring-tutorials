package com.example.library.service;

import com.example.library.property.LibraryProperties;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LibraryServiceImpl implements LibraryService {

    private final LibraryProperties properties;

    @Override
    public ResponseEntity<String> greeting() {
        return ResponseEntity.ok(properties.getGreeting());
    }
}
