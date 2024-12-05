package com.goktug.cargallerist.starter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@ComponentScan(basePackages = {"com.goktug.cargallerist"})
@EntityScan(basePackages = {"com.goktug.cargallerist"})
@EnableJpaRepositories(basePackages = {"com.goktug.cargallerist"})
@SpringBootApplication
public class CarGalleristApplication {

    public static void main(String[] args) {
        SpringApplication.run(CarGalleristApplication.class, args);
    }

}
