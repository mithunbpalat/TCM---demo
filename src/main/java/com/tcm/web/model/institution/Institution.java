package com.tcm.web.model.institution;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "institution")
public class Institution {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="tutioncenterId")
	private int tutioncenterId;
	
	@Column(name="tutioncenter")
	private String tutioncenter;
	
	@Column(name="address")
	private String address;
	
	@Column(name="mobile")
	private String mobile;
	
	@Column(name="phone")
	private String phone;
	
	@Column(name="email")
	private String email;
	
	@Column(name="district")
	private String district;
	
	@Column(name="state")
	private String state;
	
	@Column(name="pincode")
	private String pincode;

	public Institution() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Institution(int tutioncenterId, String tutioncenter, String address, String mobile, String phone,
			String email, String district, String state, String pincode) {
		super();
		this.tutioncenterId = tutioncenterId;
		this.tutioncenter = tutioncenter;
		this.address = address;
		this.mobile = mobile;
		this.phone = phone;
		this.email = email;
		this.district = district;
		this.state = state;
		this.pincode = pincode;
	}

	public int getTutioncenterId() {
		return tutioncenterId;
	}

	public void setTutioncenterId(int tutioncenterId) {
		this.tutioncenterId = tutioncenterId;
	}

	public String getTutioncenter() {
		return tutioncenter;
	}

	public void setTutioncenter(String tutioncenter) {
		this.tutioncenter = tutioncenter;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}
	
	
	
}
