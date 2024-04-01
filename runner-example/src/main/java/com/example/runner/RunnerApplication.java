package com.example.runner;

import com.ulisesbocchio.jasyptspringboot.annotation.EnableEncryptableProperties;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableEncryptableProperties
public class RunnerApplication implements ApplicationRunner, CommandLineRunner {

	@Value("${server.port:8181}")
	private String SERVER_PORT;

	//@Value("${spring.datasource.password}")
	private String dbPassword;

	public static void main(String[] args) {
		SpringApplication springApplication = new SpringApplication(RunnerApplication.class);
		springApplication.setAdditionalProfiles("prod");
		springApplication.run(args);
	}

	@Override
	public void run(ApplicationArguments args) {
		System.out.println("This is application line runner.");
		System.out.println("SERVER_PORT = " + SERVER_PORT);
	}

	@Override
	public void run(String... args) {
		System.out.println("This is command line runner.");
		System.out.println("dbPassword = " + dbPassword);
	}
}
