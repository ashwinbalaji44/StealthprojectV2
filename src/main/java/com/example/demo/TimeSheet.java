package com.example.demo;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import org.hibernate.annotations.Fetch;

import java.sql.Date;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity

@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Timesheet")
public class TimeSheet 
{
	@Id
	private int timesheet_id;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern="dd-MM-yyyy")
	private Date date;
	private int check_in;
	private int check_out;
	private int min_work_hours;
	private int break_time;
	private int overtime_hours;
	private int total_hours_worked;
	@ManyToOne
	@JoinColumn(name = "emp_id")
	private Employee emp_t;
	
	@JsonBackReference
	public Employee getEmp_t() {
		return emp_t;
	}
	public void setEmp_t(Employee emp_t) {
		this.emp_t = emp_t;
	}
	
	public int getTimesheet_id() {
		return timesheet_id;
	}
	public void setTimesheet_id(int timesheet_id) {
		this.timesheet_id = timesheet_id;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public int getCheck_in() {
		return check_in;
	}
	public void setCheck_in(int check_in) {
		this.check_in = check_in;
	}
	public int getCheck_out() {
		return check_out;
	}
	public void setCheck_out(int check_out) {
		this.check_out = check_out;
	}
	public int getMin_work_hours() {
		return min_work_hours;
	}
	public void setMin_work_hours(int min_work_hours) {
		this.min_work_hours = min_work_hours;
	}
	public int getBreak_time() {
		return break_time;
	}
	public void setBreak_time(int break_time) {
		this.break_time = break_time;
	}
	public int getOvertime_hours() {
		return overtime_hours;
	}
	public void setOvertime_hours(int overtime_hours) {
		this.overtime_hours = overtime_hours;
	}
	public int getTotal_hours_worked() {
		return total_hours_worked;
	}
	public void setTotal_hours_worked(int total_hours_worked) {
		this.total_hours_worked = total_hours_worked;
	}

	@Override
	public String toString() {
		return "TimeSheet [timesheet_id=" + timesheet_id + ", date=" + date + ", check_in=" + check_in + ", check_out="
				+ check_out + ", min_work_hours=" + min_work_hours + ", break_time=" + break_time + ", overtime_hours="
				+ overtime_hours + ", total_hours_worked=" + total_hours_worked + ", emp_t=" + emp_t + "]";
	}
	
}
