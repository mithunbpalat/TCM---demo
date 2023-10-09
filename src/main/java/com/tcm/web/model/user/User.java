package com.tcm.web.model.user;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name = "user")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="uid")
	private int uid;
	
	@Column(name="name")
	private String name;
	
	@Column(name="tutioncenter")
	private String tutioncenter;
	
	@Column(name="tutioncenterId")
	private int tutioncenterId;
	
	@Column(name="role")
	private String role;
	
	@Column(name="username")
	private String username;
	
	@Column(name="password")
	private String password;

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public User(int uid, String name, String tutioncenter, int tutioncenterId, String role, String username,
			String password) {
		super();
		this.uid = uid;
		this.name = name;
		this.tutioncenter = tutioncenter;
		this.tutioncenterId = tutioncenterId;
		this.role = role;
		this.username = username;
		this.password = password;
	}

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTutioncenter() {
		return tutioncenter;
	}

	public void setTutioncenter(String tutioncenter) {
		this.tutioncenter = tutioncenter;
	}

	public int getTutioncenterId() {
		return tutioncenterId;
	}

	public void setTutioncenterId(int tutioncenterId) {
		this.tutioncenterId = tutioncenterId;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

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

	
		
}
