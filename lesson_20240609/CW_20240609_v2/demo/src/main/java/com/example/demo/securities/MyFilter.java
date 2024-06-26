package com.example.demo.securities;

import com.nimbusds.jwt.JWTClaimsSet;
import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.text.ParseException;
import java.time.LocalTime;

@Component
public class MyFilter implements Filter {

    @Autowired
    JWTUtil jwtUtil;

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest request = (HttpServletRequest) servletRequest;

        final String authorizationHeader = request.getHeader("Authorization");
        System.out.println("Authorization : " + authorizationHeader);

        String jwt = null;

        if (authorizationHeader != null &&
            !authorizationHeader.isEmpty() &&
            authorizationHeader.startsWith("Bearer ")) {
            jwt = authorizationHeader.substring("Bearer ".length());
        }

        try {
            JWTClaimsSet claims = jwtUtil.extractAllClaims(jwt);
            String result = jwtUtil.convertToString(claims);
            System.out.println("Result: " + result.toString());
        } catch (ParseException e) {
            servletResponse.getWriter().write(">> Invalid token" + e.getMessage());
            return;
        }

        System.out.print("Request " + request.getRemoteAddr() + " time : " + LocalTime.now());
        if (request.getHeader("apiKey") == null || !request.getHeader("apiKey").equals("secret12345")) {
            servletResponse.getWriter().write("Api key not correct");
            System.out.println(" access denied (отказано в доступе)");

        }else{
            System.out.println(" access received!!! (доступ получен)");
            filterChain.doFilter(servletRequest,servletResponse);
        }
    }
}
