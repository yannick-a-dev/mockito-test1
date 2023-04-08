package com.mocktotest.mockitotest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mocktotest.mockitotest.entity.User;
import com.mocktotest.mockitotest.service.UserService;

@RestController
public class UserController {

	@Autowired
	private UserService userService;
	
	@PostMapping(value = "/save")
	public User saveUser(@RequestBody User user) {
		return userService.addUser(user);
	}
	
	@GetMapping("/users")
	public List<User> findAllUsers(){
		return userService.getUsers();
	}
	
	@GetMapping("/userByAddress/{address}")
	public List<User> findUserByAddress(@PathVariable String address){
		return userService.getUserByAddress(address);
	}
	
	@DeleteMapping(value = "/remove")
	public User removeUser(@RequestBody User user) {
		userService.deleteUser(user);
		return user;
	}
}
