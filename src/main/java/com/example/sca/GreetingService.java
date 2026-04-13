package com.example.sca;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.yaml.snakeyaml.Yaml;

import java.util.Map;

public class GreetingService {

    private final ObjectMapper objectMapper = new ObjectMapper();
    private final Yaml yaml = new Yaml();

    public String greet(String name) {
        return "Hello, " + name + "! This app uses Spring Core 6.2.5 for SCA testing.";
    }

    public String toJson(Object obj) throws Exception {
        return objectMapper.writeValueAsString(obj);
    }

    public Map<String, Object> parseYaml(String yamlContent) {
        return yaml.load(yamlContent);
    }
}
