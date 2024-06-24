package com.example.demo_api.services;

import com.example.demo_api.entities.User;
import com.example.demo_api.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;
import java.util.Optional;
import java.util.Random;

@Service
public class UserService {
    private final UserRepository userRepository;
    private static final Random RANDOM = new SecureRandom();
    private static final int API_KEY_LENGTH = 5;
    private static final String ALPHABET = "abcdefghijklmnopqrstuvwxyz";

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public String getApiKey(String email) {
        Optional<User> existingUser = userRepository.findByEmail(email);
        if (existingUser.isPresent()) {
            return "You already have API Key";
        } else {
            String apiKey = generateApiKey();
            User newUser = new User();
            newUser.setEmail(email);
            newUser.setApiKey(apiKey);
            userRepository.save(newUser);
            return apiKey;
        }
    }

    private String generateApiKey() {
        StringBuilder apiKey = new StringBuilder(API_KEY_LENGTH);
        for (int i = 0; i < API_KEY_LENGTH; i++) {
            apiKey.append(ALPHABET.charAt(RANDOM.nextInt(ALPHABET.length())));
        }
        return apiKey.toString();
    }
}
