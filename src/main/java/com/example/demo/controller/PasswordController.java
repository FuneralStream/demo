package com.example.demo.controller;

import com.example.demo.entity.Password;
import com.example.demo.repository.PasswordRepository;
import com.example.demo.service.PasswordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PasswordController {
    private final PasswordRepository passwordRepository;
    private final PasswordService passwordService;

    @Autowired
    public PasswordController(PasswordRepository passwordRepository, PasswordService passwordService) {
        this.passwordRepository = passwordRepository;
        this.passwordService = passwordService;
    }

    @PostMapping("/generate-passwords")
    public void generatePasswords() {
        passwordService.generateAndSavePasswords();
    }

    @GetMapping("/get-passwords")
    public List<Password> getAllPasswords() {
        return passwordRepository.findAll();
    }
}