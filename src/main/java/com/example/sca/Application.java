package com.example.sca;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "com.example.sca")
public class Application {

    public static void main(String[] args) {
        try (AnnotationConfigApplicationContext context =
                     new AnnotationConfigApplicationContext(Application.class)) {

            GreetingService greetingService = context.getBean(GreetingService.class);
            System.out.println(greetingService.greet("SCA Tool"));

            System.out.println("Spring Core version: " +
                    org.springframework.core.SpringVersion.getVersion());
        }
    }

    @Bean
    public GreetingService greetingService() {
        return new GreetingService();
    }
}
