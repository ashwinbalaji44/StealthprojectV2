package com.example.demo;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TimeSheet_Service 
{
	@Autowired
	TimeSheet_Repo tr;
	
	public List<TimeSheet> viewattendance(int emp_id)
	{
		
		return tr.viewAttendance(emp_id);
	}
}
