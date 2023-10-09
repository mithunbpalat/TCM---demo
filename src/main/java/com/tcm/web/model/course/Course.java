package com.tcm.web.model.course;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "course")
public class Course {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="cid")
	private int cid;
	
	@Column(name="code")
	private String code;
	
	@Column(name="course")
	private String course;
	
	@Column(name="fees")
	private String fees;
	
	@Column(name="duration")
	private String duration;
	
	public Course() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Course(int cid, String code, String course, String fees, String duration) {
		super();
		this.cid = cid;
		this.code = code;
		this.course = course;
		this.fees = fees;
		this.duration = duration;
	}

	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getCourse() {
		return course;
	}

	public void setCourse(String course) {
		this.course = course;
	}

	public String getFees() {
		return fees;
	}

	public void setFees(String fees) {
		this.fees = fees;
	}

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}


	
	
	
	
}
