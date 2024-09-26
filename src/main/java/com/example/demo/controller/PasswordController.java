package com.example.demo.controller;

import com.example.demo.entity.Password;
import com.example.demo.service.PasswordService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class PasswordController {
    private final PasswordService passwordService;

    @PostMapping("/generate-passwords")
    public void generatePasswords() {
        passwordService.generateAndSavePasswords();
    }

    @GetMapping("/get-passwords")
    public List<Password> getAllPasswords() {
        return passwordService.getAllPasswords();
    }
}