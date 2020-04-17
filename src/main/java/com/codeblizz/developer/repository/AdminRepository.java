package com.codeblizz.developer.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.codeblizz.developer.model.Admins;

@Repository
public interface AdminRepository extends MongoRepository<Admins, String>{

	List<Admins> findAllById(String adminId);
	Optional<Admins> findAdminByName(String adminName);
	Optional<Admins> findAdminByEmail(String adminEmail);
	
}
