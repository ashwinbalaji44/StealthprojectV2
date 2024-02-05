package com.example.demo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PayChart_Repo extends JpaRepository<PayChart, Integer> {
	@Query("SELECT p FROM PayChart p  WHERE p.level = :lvl and p.designation= :role")
	public PayChart getPaySlabforEmployee(@Param("lvl") String lvl,@Param("role") String role);
}
