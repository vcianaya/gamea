package com.anaya.victor.gamea.entities;

import com.squareup.moshi.Json;

import java.util.List;


public class LoginError {

	@Json(name = "message")
	private String message;

	@Json(name = "password")
	private List<String> password;

	@Json(name = "username")
	private List<String> username;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public void setPassword(List<String> password){
		this.password = password;
	}

	public List<String> getPassword(){
		return password;
	}

	public void setUsername(List<String> username){
		this.username = username;
	}

	public List<String> getUsername(){
		return username;
	}

	@Override
 	public String toString(){
		return 
			"LoginError{" + 
			"password = '" + password + '\'' + 
			",username = '" + username + '\'' + 
			"}";
		}
}