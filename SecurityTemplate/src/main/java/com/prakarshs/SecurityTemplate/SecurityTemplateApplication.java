package com.prakarshs.SecurityTemplate;

import com.prakarshs.SecurityTemplate.Entity.UserEntity;
import com.prakarshs.SecurityTemplate.Enums.Role;
import com.prakarshs.SecurityTemplate.Repository.UserRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

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
		UserEntity adminAccount = userRepository.findByRole(Role.ADMIN);
		if(adminAccount == null){
			UserEntity user = UserEntity.builder()
					.email("prakarsh2101@gmail.com")
					.firstName("Prakarsh")
					.lastName("Srivastava")
					.role(Role.ADMIN)
					.password(new BCryptPasswordEncoder().encode("admin@12345"))
					.build();
			// the detaila should be saved in a .env file
			userRepository.save(user);
		}
	}
}
