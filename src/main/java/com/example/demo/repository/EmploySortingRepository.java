package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.dto.EmployeeDTO;
import com.example.demo.model.Employee;


@Repository
public interface EmploySortingRepository extends PagingAndSortingRepository<Employee, Integer> {
			
	
		  

	}