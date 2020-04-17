package com.codeblizz.developer.controller;

import java.net.URI;
import java.net.URISyntaxException;
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
import com.codeblizz.developer.repository.AdminRepository;

@RestController
@RequestMapping("/")
@CrossOrigin(origins="http://localhost:3000", maxAge=3600)
public class AdminController {
	
	@Autowired
	AdminRepository adminRepo;
	
	private static final Logger logger = LoggerFactory.getLogger(AdminController.class);
	
	//Get Methods
	@GetMapping("/admins")
	private List<Admins> getAllAdmins(Admins adm){
		logger.info("Getting list of all admins: {}", adm);
		List <Admins> list = adminRepo.findAll();
		return list;
	}
	
	@GetMapping("/admins/{id}")
	private List<Admins> getAllAdminsById(@PathVariable String adminId){
		logger.debug("Getting list of all admins by id: {}", adminId);
		List<Admins> list = adminRepo.findAllById(adminId);
		return list;
	}
	@GetMapping("/admins/name")
	private ResponseEntity<Admins> getAdminFirstName(@PathVariable String adminName){
		logger.info("Getting an admin by name: {}", adminName);
		 Optional<Admins> admin = adminRepo.findAdminByName(adminName);
		return admin.map(res -> ResponseEntity.ok().body(res))
				.orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}
	@GetMapping("/admins/email")
	private ResponseEntity<Admins> getAdminLastName(@PathVariable String adminEmail){
		logger.info("Getting an admin by name: {}", adminEmail);
		 Optional<Admins> admin = adminRepo.findAdminByEmail(adminEmail);
		return admin.map(res -> ResponseEntity.ok().body(res))
				.orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}
	@GetMapping("/admins/{id}")
	private ResponseEntity<Admins> getAdminById(@PathVariable String adminId){
		logger.info("Getting an admin", adminId);
		Optional<Admins> adm = adminRepo.findById(adminId);
		return adm.map(res -> ResponseEntity.ok().body(res))
				.orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}
	
	//Post Methods
	@PostMapping("/admins")
	private ResponseEntity<Admins> createAdminById(@Valid @RequestBody Admins adm) throws URISyntaxException{
		logger.info("Creating an Admin: {}", adm);
		Admins admin = adminRepo.insert(adm);
		return ResponseEntity.created(new URI("/admins" + admin.getAdminId()))
				.body(admin);
	}
	@PostMapping("/admins")
	private ResponseEntity<Admins> createAdminByName(@Valid @RequestBody Admins adm) throws URISyntaxException{
		logger.info("Creating an Admin: {}", adm);
		Admins admin = adminRepo.insert(adm);
		return ResponseEntity.created(new URI("/admins" + admin.getAdminName()))
				.body(admin);
	}
	@PostMapping("/admins")
	private ResponseEntity<Admins> createAdminByEmail(@Valid @RequestBody Admins adm) throws URISyntaxException{
		logger.info("Creating an Admin: {}", adm);
		Admins admin = adminRepo.insert(adm);
		return ResponseEntity.created(new URI("/admins" + admin.getAdminEmail()))
				.body(admin);
	}
	
	//Put Methods
	@PutMapping("/admins")
	private ResponseEntity<Admins> updateAdmin(@Valid @RequestBody Admins adm){
		logger.info("Updating the admn: {}", adm);
		Admins admin = adminRepo.insert(adm);
		return ResponseEntity.ok().body(admin);
	}
	
	//Delete Methods
	@DeleteMapping("/admins")
	private ResponseEntity<Admins> deleteAdmin(Admins adm){
		logger.info("Deleting admin: {}", adm);
		adminRepo.delete(adm);
		return ResponseEntity.ok().build();
	}
	@DeleteMapping("/admins/{id}")
	private ResponseEntity<Admins> deleteAdminById(@PathVariable String adminId){
		logger.info("Deleting admin by id: {}", adminId);
		adminRepo.deleteById(adminId);
		return ResponseEntity.ok().build();
	}
}	