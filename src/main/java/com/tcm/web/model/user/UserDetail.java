package com.tcm.web.model.user;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "userdetail")
public class UserDetail {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="usdid")
	private int usdid;
	
	@Column(name="uid")
	private int uid;
	
	@Column(name="name")
	private String name;
	
	@Column(name="address")
	private String address;
	
	@Column(name="phone")
	private String phone;
	
	@Column(name="mobile")
	private String mobile;
	
	@Column(name="email")
	private String email;
	
	@Column(name="tutioncenterId")
	private int tutioncenterId;

	public UserDetail() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UserDetail(int usdid, int uid, String name, String address, String phone, String mobile, String email,
			int tutioncenterId) {
		super();
		this.usdid = usdid;
		this.uid = uid;
		this.name = name;
		this.address = address;
		this.phone = phone;
		this.mobile = mobile;
		this.email = email;
		this.tutioncenterId = tutioncenterId;
	}

	public int getUsdid() {
		return usdid;
	}

	public void setUsdid(int usdid) {
		this.usdid = usdid;
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getTutioncenterId() {
		return tutioncenterId;
	}

	public void setTutioncenterId(int tutioncenterId) {
		this.tutioncenterId = tutioncenterId;
	}

	

	
	
}
