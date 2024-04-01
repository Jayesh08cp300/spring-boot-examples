package com.example;

import com.example.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableCaching
public class ApplicationMain {
	@Autowired
	private CacheManager cacheManager;
	@Autowired
	private StudentService studentService;

	public static void main(String[] args) {
		SpringApplication.run(ApplicationMain.class, args);
	}

	@Bean
	//Interface used to indicate that a bean should run when it is contained within a SpringApplication.
	public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
		return args -> {

			//This will hit the database
			System.out.println(studentService.getStudentById(1));

			//This will hit the cache - verify the message in console output
			System.out.println(studentService.getStudentById(2));

			//Access cache instance by name
			Cache cache = cacheManager.getCache("demoCache");

			//Add entry to cache
			cache.put(4, "Hello");

			//Get entry from cache
			System.out.println(cache.get(3)
					.get());
		};
	}
}
