package com.example.controller;

import com.example.repository.UserRepository;
import com.example.dto.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

	@Autowired
	private UserRepository userRepository;

	@GetMapping("/loadUsers")
	public List<User> getUsers() {
		return userRepository.getAllUsers();
	}

}
