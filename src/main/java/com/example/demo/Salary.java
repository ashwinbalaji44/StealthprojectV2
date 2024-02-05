package com.example.demo;

import java.sql.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity

@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Salary")
public class Salary {
	@Id
	private int salary_id;
	private double pf;
	private Date transaction_date;
	private double basicpay;
	private double da;
	private double hra;
	private double grosssalary;
	private double tax;
	private double deduction;
	private double netpay;


	@ManyToOne
	@JoinColumn(name = "emp_id")
	private Employee emp_s;


	public int getSalary_id() {
		return salary_id;
	}


	public void setSalary_id(int salary_id) {
		this.salary_id = salary_id;
	}


	public double getPf() {
		return pf;
	}


	public void setPf(double pf) {
		this.pf = pf;
	}


	public Date getTransaction_date() {
		return transaction_date;
	}


	public void setTransaction_date(Date transaction_date) {
		this.transaction_date = transaction_date;
	}


	public double getBasicpay() {
		return basicpay;
	}


	public void setBasicpay(double basicpay) {
		this.basicpay = basicpay;
	}


	public double getDa() {
		return da;
	}


	public void setDa(double da) {
		this.da = da;
	}


	public double getHra() {
		return hra;
	}


	public void setHra(double hra) {
		this.hra = hra;
	}


	public double getGrosssalary() {
		return grosssalary;
	}


	public void setGrosssalary(double grosssalary) {
		this.grosssalary = grosssalary;
	}


	public double getTax() {
		return tax;
	}


	public void setTax(double tax) {
		this.tax = tax;
	}


	public double getDeduction() {
		return deduction;
	}


	public void setDeduction(double deduction) {
		this.deduction = deduction;
	}


	public double getNetpay() {
		return netpay;
	}


	public void setNetpay(double netpay) {
		this.netpay = netpay;
	}

	@JsonBackReference
	public Employee getEmp_s() {
		return emp_s;
	}


	public void setEmp_s(Employee emp_s) {
		this.emp_s = emp_s;
	}


}
