package com.example.sca;

import com.fasterxml.jackson.databind.ObjectMapper;

public class GreetingService {

    private final ObjectMapper objectMapper = new ObjectMapper();

    public String greet(String name) {
        return "Hello, " + name + "! This app uses Spring Core 6.2.5 for SCA testing.";
    }

    public String toJson(Object obj) throws Exception {
        return objectMapper.writeValueAsString(obj);
    }
}
