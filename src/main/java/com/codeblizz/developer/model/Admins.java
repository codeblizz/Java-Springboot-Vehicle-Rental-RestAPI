package com.codeblizz.developer.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.CompoundIndex;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
@Document(collection="admin_data")
@CompoundIndex(def="{'adminId': 1, 'adminName': 1, 'adminEmail': 1} ", name="admin_index")
public class Admins {
	
	@Id
	private String adminId; 
	
	private String adminName;
	private String adminEmail;
	
	Users user;
	Vehicles vehicle;
	
	public String getAdminId() {
		return adminId;
	}
	public String getAdminName() {
		return adminName;
	}
	public String getAdminEmail() {
		return adminEmail;
	}
}
