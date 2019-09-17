package com.spring.login.guide;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.spring.login.guide.models.User;
import com.spring.login.guide.repository.UserRepository;

@SpringBootApplication
public class SpringBootLoginGuideApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(SpringBootLoginGuideApplication.class, args);
	}
	
	@Bean
	CommandLineRunner save(UserRepository userRepository, PasswordEncoder passwordEncoder) {
		return args -> {
			userRepository.save(new User("ehdaudrnr3", passwordEncoder.encode("1111"), 29));
			userRepository.save(new User("kmg878", passwordEncoder.encode("878"), 27));
			userRepository.save(new User("hyejizz", passwordEncoder.encode("zz"), 26));
		};
	}
}
