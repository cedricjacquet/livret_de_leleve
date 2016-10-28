package org.cedricjacquet;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@EnableWebMvc
@EnableCaching(proxyTargetClass = true)
public class Application {
	
	/**
	 * Main spring boot application launcher
	 * @param args
	 */
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}