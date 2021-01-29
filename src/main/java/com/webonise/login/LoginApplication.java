package com.webonise.login;

import org.apache.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class LoginApplication {

	private static final Logger logger = Logger.getLogger(LoginApplication.class);
	public static void main(String[] args) {
		 if(logger.isDebugEnabled()){
	            logger.debug("$$$$$$$ LoginApplication is executed! $$$$$$$$");
	        }
		SpringApplication.run(LoginApplication.class, args);
	}
}
