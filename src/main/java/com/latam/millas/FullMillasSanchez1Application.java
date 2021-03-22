package com.latam.millas;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.logging.ConsoleHandler;
import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.LogManager;


@SpringBootApplication
@EntityScan("com.latam.entities")
@EnableJpaRepositories("com.latam.repositories")
public class FullMillasSanchez1Application {
	
	private static final Logger logger = LoggerFactory.getLogger(FullMillasSanchez1Application.class);

	public static void main(String[] args) {
		SpringApplication.run(FullMillasSanchez1Application.class, args);
	}

}
