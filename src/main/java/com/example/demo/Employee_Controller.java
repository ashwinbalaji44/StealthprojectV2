package com.example.demo;

import java.util.List;
import java.util.Optional;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping(value = "Employee")
public class Employee_Controller 
{
	@Autowired
	Employee_Service er;
	
	@Autowired
	Leave_Service lr;
	
	@Autowired
	TimeSheet_Service ts;
	
	//employee can register
	@PostMapping(value = "SignUp" , consumes = MediaType.APPLICATION_JSON_VALUE)
	public String Register_Employee(@RequestBody Employee employee) {
		return er.register_employee(employee);
	}
	
	//employee can login
	@PostMapping(value = "SignIn",consumes = MediaType.APPLICATION_JSON_VALUE)
	public String Login_Employee(@RequestBody Employee employee)
	{
		return er.login_employee(employee);
	}
	
	//employee can view his/her detail
	@GetMapping(value = "viewdetails/{email_id}",produces = MediaType.APPLICATION_JSON_VALUE)
	public Optional<Employee> viewdetails(@PathVariable("email_id") String email_id)
	{
		return er.viewemployeedetail(email_id);
	}
	
	//employee can apply leave
	@PostMapping(value = "applyleave",consumes = MediaType.APPLICATION_JSON_VALUE)
	public String Apply_Leave(@RequestBody Leave l)
	{
		return lr.apply_leave(l);
	}
	
//	@GetMapping(value = "viewleaves",produces=MediaType.APPLICATION_JSON_VALUE)
//	public Optional<List<Leave>> viewLeaves(@RequestBody int empId)
//	{
//		return er.viewallleaves(empId);
//	}
	//@PostMapping("/viewleaves")
//	public Optional<List<Leave>> viewLeaves(@RequestBody EmployeeViewLeaves employeeRequest) {
//	    int empId = employeeRequest.getEmpid();
//	    return er.viewallleaves(empId);
//	}
//	@PostMapping("/viewleaves")
//	public Optional<List<Leave>> viewLeaves(@RequestBody EmployeeViewLeaves employeeRequest) 
//	{
//	    int empId = employeeRequest.getEmp_id();
//	    System.out.println(empId);
//	    //empId=1003;
//	    return er.viewallleaves(empId);
//	    // ...
//	}
//	@GetMapping(value="viewleaves/{empIid}",produces = MediaType.APPLICATION_JSON_VALUE)
//	public Optional<List<Leave>> viewLeaves(@PathVariable("empId") int empId) {
//		return lr.viewallleaves(empId);
//	
//	}
	@GetMapping(value="viewleaves/{emp_id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Leave> viewLeaves(@PathVariable("emp_id") int emp_id) {
	    return lr.viewallleaves(emp_id);
	}
	
	@PostMapping(value = "markattendance",consumes = MediaType.APPLICATION_JSON_VALUE)
	public String mark_attendance(@RequestBody TimeSheet t)
	{
		return er.daily_attendance(t);
	}
	
	@GetMapping(value="viewattendance/{emp_id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<TimeSheet> viewAttendance(@PathVariable("emp_id") int emp_id) {
	    return ts.viewattendance(emp_id);
	}
	


	

	
	
}
