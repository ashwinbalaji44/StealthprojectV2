package com.example.demo;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface Salary_Repo extends JpaRepository<Salary, Integer> {
	@Query("SELECT SUM(s.pf) FROM Salary s  WHERE s.transaction_date BETWEEN :startDate AND :endDate")
	public double getsumofpf( @Param("startDate") LocalDate startDate, @Param("endDate") LocalDate endDate);
	
	@Query("SELECT SUM(s.tax) FROM Salary s  WHERE s.transaction_date BETWEEN :startDate AND :endDate")
	public double getsumoftax( @Param("startDate") LocalDate startDate, @Param("endDate") LocalDate endDate);
	
	 @Query("SELECT MONTH(s.transaction_date) AS month, SUM(s.netpay) AS totalCtc FROM Salary s WHERE YEAR(s.transaction_date) = :year GROUP BY MONTH(s.transaction_date) ORDER BY MONTH(s.transaction_date)")
	    List<Object[]> findCtcSumByMonthForYear(@Param("year") int year);
}
