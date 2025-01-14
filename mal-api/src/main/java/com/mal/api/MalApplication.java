package com.mal.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ImportResource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@ImportResource("classpath:applicationContext.xml")
public class MalApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(MalApplication.class, args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(MalApplication.class);
    }

    @RequestMapping(value = "nagap", method = RequestMethod.GET)
    public String getSomething() {
        return "something";
    }
}
