package com.example.demo.config;

import com.example.demo.securities.MyFilter;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class WebConfig {

    @Bean
    public FilterRegistrationBean<MyFilter> loggingFilter() {
        FilterRegistrationBean<MyFilter> registrationBean = new FilterRegistrationBean<>();

        registrationBean.setFilter(new MyFilter());
        registrationBean.addUrlPatterns("/api/*");

        return registrationBean;
    }
}

