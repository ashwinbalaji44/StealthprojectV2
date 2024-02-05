package com.example.demo;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Service
public class Employee_Service 
{
	@Autowired
	Employee_Repo er;
	
	
	
//	@Autowired
//	Leave_Repo lr;
	
	@Autowired
	TimeSheet_Repo tr;
	
	
	public String register_employee(Employee e)
	{
		Optional<Employee> result = er.findById(e.getEmp_id());
		if(result.isPresent()) {
					return "Employee already Exist";
		}
		else
		{
			try 
			{
			er.save(e);
			return "Employee Registration Successful";
			}
		catch(Exception p) 
		{
			return "Email Already exists";
		}
		}
		
	}
	
	public String login_employee(Employee e)
	{
		Optional<Employee> result = er.findById(e.getEmp_id());
		if(result.isPresent()) {
			Employee e1 = result.get();
			if(e1.getPassword().equals(e.getPassword()))
			{
				return "Employee Login Succesfull";
			}
			else
			{
				return "invalid Password";
			}
					
		}
		else
		{
			
			return "Employee  not found";
		}
		
	}
	public List<Employee> viewallemployee() {
		List<Employee> result = er.findAll();
		return result;
	}
	
	
	public Optional<Employee> viewemployeedetail(String email_id)
	{
		return er.findByEmail(email_id);
		
	}
	
//	public String apply_leave(Leave l)
//	{
//		l.setLeave_status("awaiting approval");
//		lr.save(l);
//		return "Leve request subimitted";
//		
//	}
	
//	public Optional<List<Leave>> viewallleaves(int empID)
//	{
//		
//		return lr.viewAllLeaves(empID);
//	}
	
	public String daily_attendance(TimeSheet t)
	{
		int overtime_calc=(t.getCheck_out()-t.getCheck_in())-t.getMin_work_hours();
		int worked_hours=(t.getCheck_out()-t.getCheck_in());
		t.setTotal_hours_worked(worked_hours);
		t.setOvertime_hours(overtime_calc);
		tr.save(t);
		return "attendance marked succesfully";
	}
//	public List<TimeSheet> viewattendance(int emp_id)
//	{
//		
//		return tr.viewAttendance(emp_id);
//	}
	
	
//	 @GetMapping("/searchemployee/{designation}")
//	    public ResponseEntity<List<Employee>> searchEmployees(@Param("designation") String designation,@RequestParam("query") String query){
//	        return ResponseEntity.ok(er.searchEmployees(designation, query));
//	    }

}
