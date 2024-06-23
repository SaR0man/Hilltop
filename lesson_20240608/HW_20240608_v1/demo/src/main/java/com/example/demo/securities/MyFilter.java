package com.example.demo.securities;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class MyFilter implements Filter {

    public static final Map<String, String> emailApiKeyMap = new HashMap<>();
    private static final String ALPHABET = "abcdefghijklmnopqrstuvwxyz";
    private static final int API_KEY_LENGTH = 5;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        // Инициализация фильтра
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;

        String email = httpRequest.getHeader("email");

        if (email != null) {
            if (emailApiKeyMap.containsKey(email)) {
                httpResponse.getWriter().write("you are already registered");
                return;
            } else {
                String apiKey = generateApiKey();
                emailApiKeyMap.put(email, apiKey);
                httpResponse.getWriter().write(apiKey);
                return;
            }
        }

        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {
        // Очистка фильтра
    }

    private String generateApiKey() {
        StringBuilder apiKey = new StringBuilder(API_KEY_LENGTH);
        Random random = new Random();
        for (int i = 0; i < API_KEY_LENGTH; i++) {
            apiKey.append(ALPHABET.charAt(random.nextInt(ALPHABET.length())));
        }
        return apiKey.toString();
    }
}
