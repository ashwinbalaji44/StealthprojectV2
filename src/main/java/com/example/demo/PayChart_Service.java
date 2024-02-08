package com.example.demo;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

public class PayChart_Service {

	@Autowired
	PayChart_Repo pr;
	
	public List<PayChart> viewallpaychart() {
		List<PayChart> result = pr.findAll();
		return result;
	}
	
	public String updatebasicpay(int pchartid,double basicpay) {
		// TODO Auto-generated method stub
		Optional<PayChart> result=pr.findById(pchartid);
		if(result.isPresent()) {
			PayChart p=result.get();
			p.setHourlypay(basicpay);
			pr.save(p);
			return "Basicpay changed successfully";
		}
		else
		{
			return "Invalid Paychart ID";
		}
	}
}
