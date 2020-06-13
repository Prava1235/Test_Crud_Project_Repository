package com.example.demo.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.repository.BookRepository;
import com.example.demo.repository.EmployeeRepository;
//import com.example.demo.controller.Page;
import com.example.demo.dto.EmployeeDTO;
import com.example.demo.exception.BookNotFoundException;
import com.example.demo.exception.EmployeeServiceException;
import com.example.demo.model.Book;
import com.example.demo.model.Employee;

@Service
public class EmployeeService {
	@Autowired
	EmployeeRepository employeeRepository;

	public List<EmployeeDTO> getEmpYearOfExpCount() {
		List<EmployeeDTO> empList = new ArrayList<>();
		empList = employeeRepository.getEmpYearOfExpCount();
		return empList;
	}

	public Employee findEmployeeById(Integer id) throws EmployeeServiceException {
		Employee employeeList = null;

		if (employeeList == null) {
			throw new EmployeeServiceException("Employee id not found");
		}
		return employeeList;

	}

	public List<Map<String, Object>> getEmployeeYearOfExpCountAndBandOfEmployee() {
		List empList = new ArrayList<Map<String, Object>>();
		empList = employeeRepository.getEmployeeYearOfExpCountAndBandOfEmployee();
		return empList;

	}
}
		 
		 