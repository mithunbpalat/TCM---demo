package com.tcm.web.dto;


public class UserDTO {

	private int uid;
	
	private String name;
	
	private String tutioncenter;
	
	private int tutioncenterId;
	
	private String tutioncenteridstr;
	
	private String role;
	
	private String username;

	private String password;
	
	private int usdid;
	
	private String address;
	
	private String phone;
	
	private String mobile;
	
	private String email;

	public UserDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UserDTO(int uid, String name, String tutioncenter, int tutioncenterId, String tutioncenteridstr, String role,
			String username, String password, int usdid, String address, String phone, String mobile, String email) {
		super();
		this.uid = uid;
		this.name = name;
		this.tutioncenter = tutioncenter;
		this.tutioncenterId = tutioncenterId;
		this.tutioncenteridstr = tutioncenteridstr;
		this.role = role;
		this.username = username;
		this.password = password;
		this.usdid = usdid;
		this.address = address;
		this.phone = phone;
		this.mobile = mobile;
		this.email = email;
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

	public String getTutioncenteridstr() {
		return tutioncenteridstr;
	}

	public void setTutioncenteridstr(String tutioncenteridstr) {
		this.tutioncenteridstr = tutioncenteridstr;
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

	public int getUsdid() {
		return usdid;
	}

	public void setUsdid(int usdid) {
		this.usdid = usdid;
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

	
}
