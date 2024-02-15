package com.example.demo;

import java.sql.Date;
import java.time.LocalDate;
import java.time.YearMonth;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class Salary_Service {

	@Autowired
	TimeSheet_Repo trs;
	
	@Autowired
	Salary_Repo srs;
	
	@Autowired
	PayChart_Repo prs;
	
	@Autowired
	Employee_Repo ers;
	
	 LocalDate currentDate = LocalDate.now();

     // Get the current month as a number
     int month = currentDate.getMonthValue();
	
	 int year = currentDate.getYear();
     
     // Create a YearMonth instance for the specified year and month
     YearMonth yearMonth = YearMonth.of(year, month);
     
     // Get the first day of the month
     LocalDate firstDayOfMonth = yearMonth.atDay(1);
     
     // Get the last day of the month
     LocalDate lastDayOfMonth = yearMonth.atEndOfMonth();
     
	public double getmonthlypf() {
	     return srs.getsumofpf(firstDayOfMonth, lastDayOfMonth);
	}
	
	public double getmonthlytax() {
	     return srs.getsumoftax(firstDayOfMonth, lastDayOfMonth);
	}
    
	 public int[] getMonthlyCtcForYear(int year) {
	        int[] monthlyCtc = new int[12];
	        List<Object[]> results = srs.findCtcSumByMonthForYear(year);
	        for (Object[] result : results) {
	            int month = (Integer) result[0]; // Assuming months are 1-based
	            int totalCtc = ((Number) result[1]).intValue();
	            monthlyCtc[month - 1] = totalCtc; // Adjust to 0-based index
	        }
	        return monthlyCtc;
	    }
	
	public int findNoOfDays(int emp_id) {
		return trs.findByEmployeeIdAndDateBetween(emp_id,firstDayOfMonth,lastDayOfMonth);
	}
	
	public int findMonthlyHoursWorked(int emp_id) {
		return trs.findByHourSum(emp_id,firstDayOfMonth,lastDayOfMonth);
	}
	
	
	public String creditSalary(Employee e) {
		PayChart pc=prs.getPaySlabforEmployee(e.getLevel(), e.getDesignation());
		double basicpay=pc.getHourlypay()*findMonthlyHoursWorked(e.getEmp_id())*findNoOfDays(e.getEmp_id());
		double da=basicpay*0.5;
		double hra=basicpay*0.5;
		double grosssalary=basicpay+da+hra;
		double pf=grosssalary*0.02;
		double tax=grosssalary*0.01;
		double deduction=pf+tax;
		double netpay=(2*basicpay)-deduction;
		
		Salary ss= new Salary();
		ss.setBasicpay(basicpay);
		ss.setDa(da);
		ss.setHra(hra);
		ss.setGrosssalary(grosssalary);
		ss.setPf(pf);
		ss.setTax(tax);
		ss.setDeduction(deduction);
		ss.setNetpay(netpay);
		
		ss.setTransaction_date(Date.valueOf(LocalDate.now()));
		ss.setEmp_s(e);
		srs.save(ss);
		return "Salary credited for Employee: "+e.getEmp_id();
	}
	
    
 // Runs every day at a specific time, e.g., 1:00 AM
    @Scheduled(cron = "0 0 1 * * ?")
    @Transactional
    public void creditSalariesForAllEmployees() {
        List<Employee> el = ers.findAll(); // Fetch all employees
        for (Employee employee : el) {
            // Logic to calculate and credit salary for each employee
            // This could include calling an external payment API
        	//lastDayOfMonth
        	if(currentDate.isEqual(lastDayOfMonth)) {
    			creditSalary(employee);
        	}
        }
    }
	
}
