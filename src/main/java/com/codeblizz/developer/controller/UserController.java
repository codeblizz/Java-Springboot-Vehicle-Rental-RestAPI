package com.codeblizz.developer.controller;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codeblizz.developer.model.Admins;
import com.codeblizz.developer.model.Users;
import com.codeblizz.developer.repository.UserRepository;

@RestController
@RequestMapping("/")
@CrossOrigin(origins="http://localhost:3000", maxAge=3600)
public class UserController {

	@Autowired
	UserRepository userRepo;
	
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);
	
	//Get Methods
	@GetMapping("/user")
	private Collection<Users> getAllUser(Users user) {
		logger.info("Getting all users", user);
		List<Users> users = userRepo.findAllUser(user);
		return users;
	}
	@GetMapping("/users/{id}")
	private Optional<Users> getAllUsersById(@PathVariable String userId){
		logger.info("Getting all users: {}", userId);
		Optional<Users> user = userRepo.findAllById(userId);
		return user;
	}
	@GetMapping("/user/{id}")
	private ResponseEntity<Users> getUserById(@PathVariable String userId){
		logger.info("Getting all users through http: {}", userId);
		Optional<Users> user = userRepo.findById(userId);
			return user.map(res -> ResponseEntity.ok().body(res))
				.orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}
	
	//Post Methods
	@PostMapping("/users/{id}")
	private ResponseEntity<Users> createUsersById(@PathVariable Users user) throws URISyntaxException{
		logger.info("Creating new user by id", user);
		Users users = userRepo.insert(user);
		return ResponseEntity.created(new URI("/users" + users.getUserId()))
				.body(users);			
	}
	@PostMapping("/users/{username}")
	private ResponseEntity<Users> createUsersByUserName(@PathVariable Users user) throws URISyntaxException{
		logger.info("Creating new user by id", user);
		Users users = userRepo.insert(user);
		return ResponseEntity.created(new URI("/users" + users.getUserName()))
				.body(users);			
	}
	@PostMapping("/users/{email}")
	private ResponseEntity<Users> createUsersByEmail(@PathVariable Users user) throws URISyntaxException{
		logger.info("Creating new user by id", user);
		Users users = userRepo.insert(user);
		return ResponseEntity.created(new URI("/users" + users.getUserEmail()))
				.body(users);			
	}
	
	//Put Methods
	@PutMapping("/admins")
	private ResponseEntity<Users> updateAdmin(@Valid @RequestBody Users user){
		logger.info("Updating the admn: {}", user);
		Users users = userRepo.insert(user);
		return ResponseEntity.ok().body(users);
	}
	
	//Delete Methods
	@DeleteMapping("/admins")
	private ResponseEntity<Users> deleteUser(Users user){
		logger.info("Deleting admin: {}", user);
		userRepo.delete(user);
		return ResponseEntity.ok().build();
	}
	@DeleteMapping("/admins/{id}")
	private ResponseEntity<Admins> deleteAdminById(@PathVariable String userId){
		logger.info("Deleting admin by id: {}", userId);
		userRepo.deleteById(userId);
		return ResponseEntity.ok().build();
	}
}
