package com.spring.login.guide.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Entity
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String username;
	private String password;
	private int age;
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public User() {
		// TODO Auto-generated constructor stub
	}
	
	public User(String username, String password, int age) {
		this.username = username;
		this.password = password;
		this.age = age;
	}
}
