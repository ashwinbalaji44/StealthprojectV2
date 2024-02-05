package com.example.demo;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Leave_Service 
{
	@Autowired
	Leave_Repo lr;
	@Autowired
	Employee_Repo er;
	
	public List<Leave> viewallleaves(int emp_id)
	{
		
		return lr.viewAllLeaves(emp_id);
	}
	public String apply_leave(Leave l)
	{
		String ltype=l.getLeave_type();
		int empid=l.getEmp().getEmp_id();
		if(ltype.equalsIgnoreCase("cl"))
		{
			int count_of_cl=er.count_of_cl(empid);
			if(count_of_cl>0)
			{
				l.setLeave_status("awaiting approval");
				lr.save(l);
				return "cl applied";
			}else
			{
				return "cl leave balance not enough";
			}
		}
		else 
		{
			int count_of_el=er.count_of_el(empid);
			if(count_of_el>0)
			{
				l.setLeave_status("awaiting approval");
				lr.save(l);
				return "el applied";
			}else
			{
				return "el leave balance not enough";
			}
		}
		
//		l.setLeave_status("awaiting approval");
//		lr.save(l);
		//return "invalid leave type";
		
	}
	public String approveleave(int lid) {
		// TODO Auto-generated method stub
		
		Optional<Leave> ltyefindresult=lr.findById(lid);
		Leave ltype=ltyefindresult.get();
		Leave l=lr.setLeaveStatus(lid);
		int emp_id=lr.extractEmpId(lid);
		Optional<Employee> result=er.findById(emp_id);
		Employee e=result.get();
		if(ltype.getLeave_type().equalsIgnoreCase("cl"))
		{
			
			
			
			e.setCl((e.getCl())-1);
			er.save(e);
			l.setLeave_status("Approved");
			lr.save(l);
			return "Approved CL Leave for Employee:"+l.getEmp().getEmp_id();
		}
		else
		{
			
			
			
			e.setEl((e.getEl())-1);
			er.save(e);
			l.setLeave_status("Approved");
			lr.save(l);
			return "Approved EL Leave for Employee:"+l.getEmp().getEmp_id();
		}
//		Leave l=lr.setLeaveStatus(lid);
//		int emp_id=lr.extractEmpId(lid);
//		Optional<Employee> result=er.findById(emp_id);
//		Employee e=result.get();
//		
//		e.setCl((e.getCl())-1);
//		er.save(e);
//		l.setLeave_status("Approved");
//		lr.save(l);
//		return "Approved Leave for Employee:"+l.getEmp().getEmp_id();
	}
	
	public String denyleave(int lid) {
		// TODO Auto-generated method stub
		Leave l=lr.setLeaveStatus(lid);
		l.setLeave_status("Rejected");
		lr.save(l);
		return "Denied Leave for Employee:"+l.getEmp().getEmp_id();
	}
}
