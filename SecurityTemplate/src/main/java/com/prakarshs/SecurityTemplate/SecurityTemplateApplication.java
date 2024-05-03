package com.prakarshs.SecurityTemplate;

import com.prakarshs.SecurityTemplate.Repository.UserRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Log4j2
public class SecurityTemplateApplication implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;

	public static void main(String[] args) {
		SpringApplication.run(SecurityTemplateApplication.class, args);
		log.info("*** SECURITY TEMPLATE  STARTED ***");
	}

	@Override
	public void run(String... args) throws Exception {

	}
}
