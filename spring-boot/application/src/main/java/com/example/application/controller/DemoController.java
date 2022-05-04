package com.example.application.controller;

import com.example.library.service.LibraryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api")
@RequiredArgsConstructor
public class DemoController {
    private final LibraryService libraryService;

    @GetMapping("greeting")
    public ResponseEntity<String> greeting() {
        return libraryService.greeting();
    }
}
