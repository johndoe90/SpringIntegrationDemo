package com.pf.calculator;

import java.util.Arrays;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

@Configuration
@EnableAutoConfiguration
@ComponentScan(basePackages = {"com.pf.calculator"})
@ImportResource({"classpath:com/pf/calculator/config/integration-config.xml", "classpath:com/pf/calculator/config/rabbitmq-config.xml"})
public class Application {
    public static void main(String[] args) {
       SpringApplication.run(Application.class, args);
    }
}
