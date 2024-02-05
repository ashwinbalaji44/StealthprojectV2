package com.example.demo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity

@NoArgsConstructor
@AllArgsConstructor
@Table(name = "PayChart")
public class PayChart 
{
	@Id
	private int pchart_id;

	@Column(name = "designation", unique = true)
	private String designation;
	private String level;
	private double hourlypay;
	
	public int getPchart_id() {
		return pchart_id;
	}
	public void setPchart_id(int pchart_id) {
		this.pchart_id = pchart_id;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public String getLevel() {
		return level;
	}
	public void setLevel(String level) {
		this.level = level;
	}

	public double getHourlypay() {
		return hourlypay;
		
	}
	public void setHourlypay(double hourlypay) {
		this.hourlypay = hourlypay;
		
	}
	
	
}

