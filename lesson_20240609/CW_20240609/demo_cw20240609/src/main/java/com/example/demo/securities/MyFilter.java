package com.example.demo.securities;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.time.LocalTime;

@Component
public class MyFilter implements Filter {

    @Autowired
    JWTUtil jwtUtil;

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        System.out.println("Hello!");

        HttpServletRequest request = (HttpServletRequest) servletRequest;

        final String apiKeyHeader = request.getHeader("Authorization");
        System.out.println("Authorization : " + apiKeyHeader);
        final String authorizationHeader = request.getHeader("Authorization");
        System.out.println("Authorization : " + authorizationHeader);

        System.out.print("Request " + request.getRemoteAddr() + " time : " + LocalTime.now());
        if (request.getHeader("apiKey") == null || !request.getHeader("apiKey").equals("secret12345")) {
            servletResponse.getWriter().write("Api key not correct");
            System.out.println(" access denied (отказано в доступе)");

        }else{
            System.out.println(" access received! (доступ получен)");
            filterChain.doFilter(servletRequest,servletResponse);
        }
    }
}
