package com.example.demo_api.services;

import com.example.demo_api.entities.Book;
import com.example.demo_api.entities.User;
import com.example.demo_api.repository.BookRepository;
import com.example.demo_api.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class BookService {
    private final BookRepository bookRepository;
    private final UserRepository userRepository;
    private static final int MAX_REQUESTS = 5;
    private static final Duration BLOCK_DURATION = Duration.ofMinutes(2);

    @Autowired
    public BookService(BookRepository bookRepository, UserRepository userRepository) {
        this.bookRepository = bookRepository;
        this.userRepository = userRepository;
    }

    public List<Book> getBooksByApiKey(String apiKey) {
        Optional<User> userOptional = userRepository.findByApiKey(apiKey);
        if (userOptional.isPresent()) {
            User user = userOptional.get();
            LocalDateTime now = LocalDateTime.now();

            if (user.getBlockedUntil() != null && now.isBefore(user.getBlockedUntil())) {
                return null; // Возвращаем null, чтобы обработать это в контроллере
            }

            if (user.getBlockedUntil() != null && now.isAfter(user.getBlockedUntil())) {
                // Сбрасываем счетчик и блокировку, так как время блокировки истекло
                user.setRequestCount(1); // Сбрасываем счетчик запросов и устанавливаем на 1
                user.setBlockedUntil(null);
            } else if (user.getRequestCount() >= MAX_REQUESTS) {
                user.setBlockedUntil(now.plus(BLOCK_DURATION));
                userRepository.save(user);
                return null; // Возвращаем null, чтобы обработать это в контроллере
            } else {
                user.incrementRequestCount();
            }

            userRepository.save(user);
            return bookRepository.findAll();
        } else {
            return null;
        }
    }

    public String getRemainingBlockTime(String apiKey) {
        Optional<User> userOptional = userRepository.findByApiKey(apiKey);
        if (userOptional.isPresent()) {
            User user = userOptional.get();
            LocalDateTime now = LocalDateTime.now();
            if (user.getBlockedUntil() != null && now.isBefore(user.getBlockedUntil())) {
                Duration remaining = Duration.between(now, user.getBlockedUntil());
                long minutes = remaining.toMinutes();
                long seconds = remaining.getSeconds() % 60;
                return String.format(">> The number of requests for your API key has been exceeded.\n" +
                        ">> You can make the new requests in %d min and %d sec.", minutes, seconds);
            }
        }
        return "You don't have access.";
    }
}
