package com.example.demo.repository;


import java.sql.Timestamp;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import com.example.demo.dto.EmployeeDTO;
import com.example.demo.model.Audit;
import com.example.demo.model.Book;

@Repository
public interface AuditRepository extends JpaRepository<Audit, String> {
	
	
	@Query("select a.typeOfAction from Audit a where a.typeOfAction = ?1")
	String findTypeOfActionById(Timestamp id);
	

}