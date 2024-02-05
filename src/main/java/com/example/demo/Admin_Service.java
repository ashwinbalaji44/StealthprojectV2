package com.example.demo;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Admin_Service 
{
	@Autowired
	Admin_Repo ar;
	
	public String register_admin(Admin a)
	{
		Optional<Admin> result = ar.findById(a.getEmail_id());
		if(result.isPresent()) {
					return "Admin already Exist";
		}
		else
		{
			ar.save(a);
			return "Admin Registration Successful";
		}
		
	}
	
	public String login_Admin(Admin a)
	{
		Optional<Admin> result = ar.findById(a.getEmail_id());
		if(result.isPresent()) {
			Admin a1 = result.get();
			if(a1.getPassword().equals(a.getPassword()))
			{
				return "Admin Login Succesfull";
			}
			else
			{
				return "invalid Password";
			}
					
		}
		else
		{
			
			return "Admin not registered";
		}
		
	}
}
