package com.example.demo;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface TimeSheet_Repo extends JpaRepository<TimeSheet, Integer> 
{
	@Query("SELECT p FROM TimeSheet p  WHERE p.emp_t.emp_id = :emp_id")
	public  List<TimeSheet> viewAttendance(@Param("emp_id") int emp_id);
	
	 @Query("SELECT COUNT(t) FROM TimeSheet t WHERE t.emp_t.emp_id = :employeeId AND t.date BETWEEN :startDate AND :endDate")
	    int findByEmployeeIdAndDateBetween(
	            @Param("employeeId") Integer employeeId, 
	            @Param("startDate") LocalDate startDate, 
	            @Param("endDate") LocalDate endDate);
}
