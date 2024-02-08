package com.example.demo;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping(value = "Admin")
public class Admin_Controller 
{
	@Autowired
	Admin_Service as;
	@Autowired
	Employee_Service es;
	@Autowired
	Leave_Service ls;
	@Autowired
	Salary_Service ss;
	@Autowired
	TimeSheet_Service ts;
	@Autowired
	PayChart_Service ps;
	
	//admin can register
	@PostMapping(value = "SignUp" , consumes = MediaType.APPLICATION_JSON_VALUE)
	public String Register_Admin(@RequestBody Admin admin) {
		return as.register_admin(admin);
	}
	//admin can login
	@PostMapping(value = "SignIn",consumes = MediaType.APPLICATION_JSON_VALUE)
	public String Login_Admin(@RequestBody Admin admin)
	{
		return as.login_Admin(admin);
	}
	//admin can view all employees
	@GetMapping(value="viewallemployee",produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Employee> getallproducts() {
		return es.viewallemployee();
		
	}
	@PutMapping("/approveleave/{lid}")
	public String approveemployeeleave(@PathVariable("lid") int lid ) {
		return ls.approveleave(lid);
	}
	
	@PutMapping("/denyleave/{lid}")
	public String denylemployeeleave(@PathVariable("lid") int lid ) {
		return ls.denyleave(lid);
	}
	
//	@GetMapping(value = "noofdays/{eid}" , consumes = MediaType.APPLICATION_JSON_VALUE)
//	public int NoOfDays(@PathVariable("eid") int eid) {
//		return ss.findNoOfDays(eid);
//	}
	
	@PostMapping(value = "paychart" , consumes = MediaType.APPLICATION_JSON_VALUE)
	public String AddPayChart(@RequestBody PayChart pc) {
		return as.addPayChart(pc);
	}
	
	@GetMapping(value = "viewdetails/{email_id}",produces = MediaType.APPLICATION_JSON_VALUE)
	public Optional<Employee> viewdetails(@PathVariable("email_id") String email_id)
	{
		return es.viewemployeedetail(email_id);
	}
	
	@GetMapping(value="viewattendance/{emp_id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<TimeSheet> viewAttendance(@PathVariable("emp_id") int emp_id) {
	    return ts.viewattendance(emp_id);
	}
	
	@GetMapping(value = "viewpaychart",produces = MediaType.APPLICATION_JSON_VALUE)
	public List<PayChart> viewpaychartdetails()
	{
		return ps.viewallpaychart();
	}
	@PutMapping("/updatepaychart/{pid}/{basicpay}")
	public String denylemployeeleave(@PathVariable("lid") int pid,@PathVariable("basicpay") double basicpay) {
		return ps.updatebasicpay(pid,basicpay);
	}
	//admin can search for employee using query
//	 @GetMapping("/search/{condition}")
//	    public ResponseEntity<ResponseEntity<List<Employee>>> searchEmployees(@PathVariable("condition") String condition,@RequestParam("query") String query){
//	        return ResponseEntity.ok(es.searchEmployees(condition,query));
//	    }
}
