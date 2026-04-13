package com.example.sca;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Application {

    private static final Logger log = LoggerFactory.getLogger(Application.class);

    public static void main(String[] args) {
        GreetingService greetingService = new GreetingService();

        log.info("Starting SCA Test Application");
        System.out.println(greetingService.greet("SCA Tool"));

        try {
            String json = greetingService.toJson(new String[]{"jackson", "slf4j", "logback"});
            System.out.println("Dependencies as JSON: " + json);
        } catch (Exception e) {
            log.error("JSON serialization failed", e);
        }
    }
}
