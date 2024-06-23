package com.example.demo.securities;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.time.LocalTime;

@Component
public class MyFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest request = (HttpServletRequest) servletRequest;

        System.out.print("Request " + request.getRemoteAddr() + " time : " + LocalTime.now());
        if (request.getHeader("apiKey") == null || !request.getHeader("apiKey").equals("secret12345")) {
//                     throw new Exception("Api key not correct");{
            servletResponse.getWriter().write("Api key not correct");
            System.out.println(" OTKAZANO");

        }else{
            System.out.println(" DOPUWEN");
            filterChain.doFilter(servletRequest,servletResponse);
        }


    }

//    @Override
//    public void destroy() {
//        Filter.super.destroy();
//    }
}
