package com.Ideation.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class employees {
	
	private String company;
	
	private int employeeid;
	private String fullname;
	private String gender;
	
	
	
	@Id
	@Column(unique = true)
	private String email_id;
	
	
	private String password;
	private String mobile_no;
	
	private String position;
	private String department;
	private String role;
	public employees() {
		super();
		// TODO Auto-generated constructor stub
	}
	public employees(String company, int employeeid, String fullname, String gender, String email_id, String password,
			String mobile_no, String position, String department, String role) {
		super();
		this.company = company;
		this.employeeid = employeeid;
		this.fullname = fullname;
		this.gender = gender;
		this.email_id = email_id;
		this.password = password;
		this.mobile_no = mobile_no;
		this.position = position;
		this.department = department;
		this.role = role;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public int getEmployeeid() {
		return employeeid;
	}
	public void setEmployeeid(int employeeid) {
		this.employeeid = employeeid;
	}
	public String getFullname() {
		return fullname;
	}
	public void setFullname(String fullname) {
		this.fullname = fullname;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getEmail_id() {
		return email_id;
	}
	public void setEmail_id(String email_id) {
		this.email_id = email_id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getMobile_no() {
		return mobile_no;
	}
	public void setMobile_no(String mobile_no) {
		this.mobile_no = mobile_no;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	@Override
	public String toString() {
		return "employees [company=" + company + ", employeeid=" + employeeid + ", fullname=" + fullname + ", gender="
				+ gender + ", email_id=" + email_id + ", password=" + password + ", mobile_no=" + mobile_no
				+ ", position=" + position + ", department=" + department + ", role=" + role + "]";
	}
	
	
	

	
	
	

	
	
	
	
	
 

}
