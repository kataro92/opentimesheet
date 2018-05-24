package com.kat.opentimesheet;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class OpenTimesheetApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(OpenTimesheetApplication.class, args);
    }

}