package com.codeblizz.developer.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.CompoundIndex;
//import org.springframework.data.mongodb.core.index.IndexDirection;
//import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
@Document(collection="user_data")
@CompoundIndex(def="{'userId': 1, 'userName': 1, 'userEmail': 1 }", name="user_index")
public class Users {

	@Id
	private String userId;
	//@Indexed(direction=IndexDirection.ASCENDING)
	private String userName;
	private String userEmail;
	
	public String getUserId() {
		return userId;
	}
	
	public String getUserName() {
		return userName;
	}
	
	public String getUserEmail() {
		return userEmail;
	}
}
