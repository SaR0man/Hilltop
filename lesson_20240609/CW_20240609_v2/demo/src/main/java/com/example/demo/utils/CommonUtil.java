package com.example.demo.utils;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Component;

@Component
public class CommonUtil {
    public static String getIp(HttpServletRequest request) {
        String ip = request.getRemoteAddr();
        return ip;
    }
}
