package com.example.demo.restControllers;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;
import com.example.demo.service.register.RegistrationRequest;

@RestController
@CrossOrigin(origins = "*")
public class UserRestController {
	@Autowired
	UserService userService;
	
	@Autowired
	UserRepository userRep;
	
	@GetMapping("all")
	public List<User> getAllUsers() {
		return userRep.findAll();
	}
	
	@GetMapping("/say")
	public String sayhi() {
		return "hello from earth";
	}
	
	
	@PostMapping("/register")
	public User register(@RequestBody RegistrationRequest request)
	{ 
		return userService.registerUser(request);
	}
	
	
	@GetMapping("/verifyEmail/{token}")
	public User verifyEmail(@PathVariable("token") String token) {
		return userService.validateToken(token);
	}


}

