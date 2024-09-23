package com.example.demo.controller;

import com.example.demo.service.PasswordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PasswordController {
    @Autowired
    private PasswordService passwordService;

    @PostMapping("/generate-passwords")
    public void generatePasswords() {
        passwordService.generateAndSavePasswords();
    }
}