package com.example.demo;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity

@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Leaves")
public class Leave 
{
	@Id
	private int leave_id;
	private String reason;
	private String leave_type;
	private String start_date;
	private String end_date;
	private String leave_status;
	private double duration;
	@ManyToOne
	@JoinColumn(name = "emp_id")
	private Employee emp;
	
	@JsonBackReference
	public Employee getEmp() {
		return emp;
	}
	public void setEmp(Employee emp) {
		this.emp = emp;
	}
	public int getLeave_id() {
		return leave_id;
	}
	public void setLeave_id(int leave_id) {
		this.leave_id = leave_id;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	public String getLeave_type() {
		return leave_type;
	}
	public void setLeave_type(String leave_type) {
		this.leave_type = leave_type;
	}
	public String getStart_date() {
		return start_date;
	}
	public void setStart_date(String start_date) {
		this.start_date = start_date;
	}
	public String getEnd_date() {
		return end_date;
	}
	public void setEnd_date(String end_date) {
		this.end_date = end_date;
	}
	public String getLeave_status() {
		return leave_status;
	}
	public void setLeave_status(String leave_status) {
		this.leave_status = leave_status;
	}
	public double getDuration() {
		return duration;
	}
	public void setDuration(double duration) {
		this.duration = duration;
	}

	@Override
	public String toString() {
		return "Leave [leave_id=" + leave_id + ", reason=" + reason + ", leave_type=" + leave_type + ", start_date="
				+ start_date + ", end_date=" + end_date + ", leave_status=" + leave_status + ", duration=" + duration
				+ ", emp=" + emp + "]";
	}
	
	
	
}
