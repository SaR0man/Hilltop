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
    public void doFilter(ServletRequest servletRequest,
                         ServletResponse servletResponse,
                         FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest request = (HttpServletRequest) servletRequest;

        final String authorizationHeader = request.getHeader("Authorization");
        System.out.println(">> Authorization: " + authorizationHeader);

        String jwt = null;
        boolean access = false;

        if (authorizationHeader != null &&
            !authorizationHeader.isEmpty()) {
            jwt = authorizationHeader;
        }

        if (jwt.startsWith("Bearer ")) {
            jwt = authorizationHeader.substring("Bearer ".length());
            System.out.println(">> JWT has 'Bearer' in the beginner");
        } else System.out.println(">> JWT doesn't have 'Bearer' in the beginner");


        try {
            JWTClaimsSet claims = jwtUtil.extractAllClaims(jwt);

            int idControl = 4;
            String nameControl = "Sorgu";
            String descriptionControl = "Sorgu";
            String domainControl = "https://sorgu.asan.org/";
            String labelControl = "sorgu";

            boolean isValid = jwtUtil.validateSpecificObjectInToken(claims, idControl, nameControl, descriptionControl, domainControl, labelControl);

            if (!isValid) {
                servletResponse.getWriter().write(">> Token validation failed");  // ответ фронту
                System.out.println(">> Token validation failed");
                return;
            } else {
                System.out.println(">>>> Object of type 'Sorgu' detected!");
                access = true;
            }

        } catch (ParseException e) {
            servletResponse.getWriter().write(">> Invalid token: " + e.getMessage());
            return;
        }


//        try {
//            JWTClaimsSet claims = jwtUtil.extractAllClaims(jwt);
//            String result = jwtUtil.convertToString(claims);
//            System.out.println(">> Result: " + result);
//        } catch (ParseException e) {
//            servletResponse.getWriter().write(">> Invalid token" + e.getMessage());
//            return;
//        }


        System.out.println("Request " + request.getRemoteAddr() + " time : " + LocalTime.now());
        if (request.getHeader("apiKey") == null ||
                !request.getHeader("apiKey").equals("secret12345") ||
        !access) {
            servletResponse.getWriter().write("Api key not correct");
            System.out.println(">> access denied (отказано в доступе)");

        } else {
            System.out.println(">> access received (доступ получен)");
            filterChain.doFilter(servletRequest,servletResponse);
        }
    }
}
