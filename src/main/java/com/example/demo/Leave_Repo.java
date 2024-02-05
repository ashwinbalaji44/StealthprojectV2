package com.example.demo;

import java.util.List;
import java.util.Optional;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface Leave_Repo extends JpaRepository<Leave, Integer> {

	
//	@Query("select l from Leaves l where l.emp_emp_id = :empid ")
//	public Optional <List<Leave>> viewAllLeaves(@Param("empid") int empid);
	
//	@Query("SELECT l FROM Leave l WHERE l.emp_id = :empId")
//	public Optional<List<Leave>> viewAllLeaves(@Param("empId") int empId);
	@Query("SELECT p FROM Leave p  WHERE p.emp.emp_id = :emp_id")
	List<Leave> viewAllLeaves(@Param("emp_id") int emp_id);
	
	@Query("SELECT l FROM Leave l WHERE l.leave_id = :lid and l.leave_status= 'awaiting approval'")
	public Leave setLeaveStatus(@Param("lid") int lid);
	
	@Query("SELECT p.emp.emp_id FROM Leave p  WHERE p.leave_id = :lid")
	public int extractEmpId(@Param("lid") int lid);

//	@Query("select p from Patient p where p.dpid = :did")
//	public List<Patient> findByDpid(@Param("did") int did);
	
	

	

}
