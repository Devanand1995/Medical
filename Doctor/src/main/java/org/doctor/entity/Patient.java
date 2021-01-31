package org.doctor.entity;

import java.sql.Date;

import org.springframework.web.multipart.MultipartFile;

public class Patient {

	int pid;
	String p_name ;
	Date p_dob;
	String blood_group;
	String address;
	String mobile_number;
	String email;
	Date date_of_appointment;
	MultipartFile upload;
	
	
	public Patient() {
		
	}

	public Patient(String p_name, Date p_dob, String blood_group, String address, String mobile_number,
			String email, Date date_of_appointment, MultipartFile upload) {
		super();
		this.p_name = p_name;
		this.p_dob = p_dob;
		this.blood_group = blood_group;
		this.address = address;
		this.mobile_number = mobile_number;
		this.email = email;
		this.date_of_appointment = date_of_appointment;
		this.upload = upload;
	}

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public String getP_name() {
		return p_name;
	}

	public void setP_name(String p_name) {
		this.p_name = p_name;
	}

	public Date getP_dob() {
		return p_dob;
	}

	public void setP_dob(Date p_dob) {
		this.p_dob = p_dob;
	}


	public String getBlood_group() {
		return blood_group;
	}

	public void setBlood_group(String blood_group) {
		this.blood_group = blood_group;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getMobile_number() {
		return mobile_number;
	}

	public void setMobile_number(String mobile_number) {
		this.mobile_number = mobile_number;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getDate_of_appointment() {
		return date_of_appointment;
	}

	public void setDate_of_appointment(Date date_of_appointment) {
		this.date_of_appointment = date_of_appointment;
	}

	public MultipartFile getUpload() {
		return upload;
	}

	public void setUpload(MultipartFile upload) {
		this.upload = upload;
	}
	
	
}
