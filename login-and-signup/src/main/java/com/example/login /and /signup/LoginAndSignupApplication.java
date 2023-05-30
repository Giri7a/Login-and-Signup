package com.example.login.and.signup;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
public class LoginAndSignupApplication {

	public static void main(String[] args) {
		SpringApplication.run(LoginAndSignupApplication.class, args);
	}

}
