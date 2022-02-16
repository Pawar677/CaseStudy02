package com.sonata.user.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sonata.user.entity.User;
import com.sonata.user.exception.ResuorceNotFound;
import com.sonata.user.repository.UserRepository;

@RestController
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	private UserRepository userRepository;
	
// Get All User Information
	@GetMapping
	public List<User> getAllUsers(){
		return this.userRepository.findAll();
	}
	
// Get User by id	
	@GetMapping("/{id}")
	public User getUserByName(@PathVariable ("id") long userId ) {
		 return this.userRepository.findById(userId)
					.orElseThrow(() -> new ResuorceNotFound ("User Not Found" +userId));
	}
	
	
// Get User by name
	@RequestMapping("/{firstname}")
	public List<User> getUserByFirstname(@PathVariable String firstname){
		return userRepository.findByFirstname(firstname);
	}
	
	
	
	
// Create User in Database
	
	@PostMapping
	public User CreateUser(@RequestBody User user) {
		
		return this.userRepository.save(user);
	}
	
// Update User if any
	@PutMapping("/{id}")
	public User UpdateUser(@RequestBody User user, @PathVariable ("id") long userId) {
		User excitinguser = this.userRepository.findById(userId)
		.orElseThrow(() -> new ResuorceNotFound ("User Not Found" +userId));
		excitinguser.setFirstname(user.getFirstname());
		excitinguser.setLastname(user.getLastname());
		excitinguser.setEmail(user.getEmail());
		return this.userRepository.save(excitinguser);
	}
	
// Delete User if any
	@DeleteMapping("/{id}")
	public ResponseEntity<User> deleteUser(@PathVariable ("id") long userId) {
		User excitinguser = this.userRepository.findById(userId)
				.orElseThrow(() -> new ResuorceNotFound ("User Not Found" +userId));
		this.userRepository.delete(excitinguser);
		return ResponseEntity.ok().build();
		
	}   
}
