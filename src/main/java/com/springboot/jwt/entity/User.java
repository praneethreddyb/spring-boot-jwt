package com.springboot.jwt.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "user")
public class User {
	
	@Id
	@GeneratedValue
	Integer Id;
	
	@Column(name = "user_name")
	String userName;
	
	String name;
	
	String phone;
	
	@JsonIgnore
	@Column(name = "password")
	String password;
	
	public User() {
		super();
	}

	public User(Integer id, String userName, String name, String phone) {
		super();
		Id = id;
		this.userName = userName;
		this.name = name;
		this.phone = phone;
	}
	
	
	public User(String name, String userName, String phone, String password) {
		super();
		this.name = name;
		this.userName = userName;
		this.phone = phone;
		this.password=password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Integer getId() {
		return Id;
	}

	public void setId(Integer id) {
		Id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}


}
