package com.example.demo.models;

import org.springframework.http.HttpInputMessage;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.MediaType;
import org.springframework.http.converter.AbstractHttpMessageConverter;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

public class JavaScriptMessageConverter extends AbstractHttpMessageConverter<Object> {

    private final ObjectMapper objectMapper;

    public JavaScriptMessageConverter() {
        super(new MediaType("application", "javascript"));
        this.objectMapper = new ObjectMapper();
    }

    @Override
    protected boolean supports(Class<?> clazz) {
        return true;
    }

    @Override
    protected Object readInternal(Class<?> clazz, HttpInputMessage inputMessage) throws IOException {
        return objectMapper.readValue(inputMessage.getBody(), clazz);
    }

    @Override
    protected void writeInternal(Object o, HttpOutputMessage outputMessage) throws IOException {
        objectMapper.writeValue(outputMessage.getBody(), o);
    }
}
