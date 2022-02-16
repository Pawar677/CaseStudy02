package com.sonata.user.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sonata.user.entity.User;
import com.sonata.user.repository.UserRepository;

@Service

public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	public List<User> getUserByFirstname(String firstname){
		return userRepository.findByFirstname(firstname);
	}
	
/*	public List<User> gertUserByLastname(String lastname) {
		return userRepository.findByLirstname(lastname);
	}
*/
	
	
}
