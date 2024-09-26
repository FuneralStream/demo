package com.example.demo.service;

import com.example.demo.entity.Password;
import com.example.demo.repository.PasswordRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
@RequiredArgsConstructor
public class PasswordService {
    private final PasswordRepository passwordRepository;

    public void generateAndSavePasswords() {
        for (int i = 0; i < 100; i++) {
            String password = generateRandomPassword(10);
            Password newPassword = new Password();
            newPassword.setPassword(password);
            passwordRepository.save(newPassword);
        }
    }

    private String generateRandomPassword(int length) {
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        StringBuilder password = new StringBuilder();
        for (int i = 0; i < length; i++) {
            int randomIndex = new Random().nextInt(characters.length());
            password.append(characters.charAt(randomIndex));
        }
        return password.toString();
    }

    public List<Password> getAllPasswords() {
        return passwordRepository.findAll();
    }
}
