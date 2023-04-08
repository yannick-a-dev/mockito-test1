package com.mocktotest.mockitotest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mocktotest.mockitotest.entity.User;
import com.mocktotest.mockitotest.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;

	public User addUser(User user) {
		return userRepository.save(user);
	}

	public List<User> getUsers() {
		List<User> users = userRepository.findAll();
		System.out.println("Getting data from DB : " + users);
		return users;
	}

	public List<User> getUserByAddress(String address) {
		return userRepository.findByAddress(address);
	}

	public void deleteUser(User user) {
		userRepository.delete(user);
	}

}
