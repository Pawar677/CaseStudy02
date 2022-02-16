package com.sonata.user.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.sonata.user.entity.User;

@Repository
public interface UserRepository extends JpaRepository <User, String> {

	public List<User> findByFirstname(String firstname);
//	public List<User> findByLastname(String lastname);

	public Optional<User> findById(long userId);
	
}
