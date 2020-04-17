package com.codeblizz.developer.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.codeblizz.developer.model.Users;

@Repository
public interface UserRepository extends MongoRepository<Users, String>{
	
	Optional<Users> findAllById(String userId);

	List<Users> findAllUser(Users user);

}
