package com.example.application.controller;

import com.example.library.service.LibraryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * Demo rest controller.
 * @author vitali
 */
@RestController
@RequestMapping("api")
@RequiredArgsConstructor
public class DemoController {

    /**
     *
     * Library service.
     */
    private final LibraryService libraryService;

    /**
     *
     * Get greeting msg.
     * @return Response Entity
     */
    @GetMapping("greeting")
    public ResponseEntity<String> greeting() {
        return libraryService.greeting();
    }
}
