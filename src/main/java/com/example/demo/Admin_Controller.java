package com.example.demo;

import java.util.List;

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
	
	@GetMapping(value = "noofdays/{eid}" , consumes = MediaType.APPLICATION_JSON_VALUE)
	public int NoOfDays(@PathVariable("eid") int eid) {
		return ss.findNoOfDays(eid);
	}
	
	
	
	//admin can search for employee using query
//	 @GetMapping("/search/{condition}")
//	    public ResponseEntity<ResponseEntity<List<Employee>>> searchEmployees(@PathVariable("condition") String condition,@RequestParam("query") String query){
//	        return ResponseEntity.ok(es.searchEmployees(condition,query));
//	    }
}
