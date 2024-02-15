	package com.example.demo;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity

@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Employee")
public class Employee 
{
	@Id
	private int emp_id;
	private String profile_pic;
	private String f_name;
	private String l_name;
	private String dob;
	private String gender;
	private String street;
	private String location;
	private String city;
	private String state;
	private int pincode;
	private double mobile_number;
	private String pan_number;
	private String father_name;
	private double bank_accnumber;

	@Column(name = "email_id", unique = true)
	private String email_id;
	private String password;
	private String designation;
	private String level;
	private int cl;
	private int el;
	@OneToMany(mappedBy = "emp")
	private  List<Leave> leaves;
	
	
	@OneToMany(mappedBy = "emp_t")
	private  List<TimeSheet> timesheet;
	
	
	@OneToMany(mappedBy = "emp_s")
	private  List<Salary> salary;
	//@OneToMany
//	@JoinColumn(name="empId")
//	private List<Leave> leaves;
	
	@JsonManagedReference
	public List<Leave> getLeaves() {
		return leaves;
	}
	public int getEmp_id() {
		return emp_id;
	}
	@JsonManagedReference
	public List<TimeSheet> getTimesheet() {
		return timesheet;
	}
	public void setTimesheet(List<TimeSheet> timesheet) {
		this.timesheet = timesheet;
	}
	public void setEmp_id(int emp_id) {
		this.emp_id = emp_id;
	}
	public String getF_name() {
		return f_name;
	}
	public void setF_name(String f_name) {
		this.f_name = f_name;
	}
	public String getL_name() {
		return l_name;
	}
	public void setL_name(String l_name) {
		this.l_name = l_name;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public int getPincode() {
		return pincode;
	}
	public void setPincode(int pincode) {
		this.pincode = pincode;
	}
	public double getMobile_number() {
		return mobile_number;
	}
	public void setMobile_number(double mobile_number) {
		this.mobile_number = mobile_number;
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
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public void setLeaves(List<Leave> leaves) {
		this.leaves = leaves;
	}
	public int getCl() {
		return cl;
	}
	public void setCl(int cl) {
		this.cl = cl;
	}
	public int getEl() {
		return el;
	}
	public void setEl(int el) {
		this.el = el;
	}
	@JsonManagedReference
	public List<Salary> getSalary() {
		return salary;
	}
	public void setSalary(List<Salary> salary) {
		this.salary = salary;
	}
	public String getLevel() {
		return level;
		
	}
	public void setLevel(String level) {
		this.level = level;
		
	}
	public String getProfile_pic() {
		return profile_pic;
	}
	public void setProfile_pic(String profile_pic) {
		this.profile_pic = profile_pic;
	}
	public String getPan_number() {
		return pan_number;
	}
	public void setPan_number(String pan_number) {
		this.pan_number = pan_number;
	}
	public String getFather_name() {
		return father_name;
	}
	public void setFather_name(String father_name) {
		this.father_name = father_name;
	}
	public double getBank_accnumber() {
		return bank_accnumber;
	}
	public void setBank_accnumber(double bank_accnumber) {
		this.bank_accnumber = bank_accnumber;
	}

	
	
}
