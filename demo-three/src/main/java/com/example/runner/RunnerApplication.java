package com.example.runner;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RunnerApplication implements ApplicationRunner, CommandLineRunner {

	@Value("${server.port:8181}")
	private String SERVER_PORT;

	public static void main(String[] args) {
		SpringApplication springApplication = new SpringApplication(RunnerApplication.class);
		springApplication.setAdditionalProfiles("prod");
		springApplication.run(args);
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
		System.out.println("This is application line runner.");
		System.out.println("SERVER_PORT = " + SERVER_PORT);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("This is command line runner.");
	}
}
