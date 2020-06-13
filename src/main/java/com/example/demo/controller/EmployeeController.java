package com.example.demo.controller;

import java.net.URI;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.demo.dto.EmployeeDTO;
import com.example.demo.exception.BookNotFoundException;
import com.example.demo.exception.EmployeeServiceException;
import com.example.demo.model.Employee;
import com.example.demo.repository.EmployeeRepository;
import com.example.demo.model.Book;
import com.example.demo.service.BookService;
import com.example.demo.service.EmployeeService;

import io.swagger.annotations.ApiOperation;

@RestController
public class EmployeeController {
	@Autowired
	EmployeeService employeeService;
	@Autowired
	EmployeeRepository employeeRepository;

	@RequestMapping(value = "/employees", method = RequestMethod.GET)
	public List<EmployeeDTO> getEmpYearOfExpCount() {
		return employeeService.getEmpYearOfExpCount();
	}

	@RequestMapping(value = "/employeesbasedonyearexp", method = RequestMethod.GET)
	public List<Employee> findEmployeeById(@RequestParam Integer id) {
		if (id < 5) {
			return employeeRepository.findEmployeeByYearOfExperienceLessThenFive();
		} else if (id > 5 && id < 10) {
			return employeeRepository.findEmployeeByYearOfExperienceBetweenFiveAndTen();
		} else {
			return employeeRepository.findEmployeeByYearOfExperienceGreatersThenTen();
		}

	}

	@RequestMapping(value = "/employeesbandbasedonyearofexp", method = RequestMethod.GET)
	public List<Map<String, Object>> getEmployeeYearOfExpCountAndBandOfEmployee() {
		return employeeService.getEmployeeYearOfExpCountAndBandOfEmployee();
	}
	
	@RequestMapping(value = "/employees/{id}", method = RequestMethod.GET)
	@ApiOperation(value = "Find the Employee By Id", notes = "Provide the empid  to get the Employee Info for a given empid ", response = Employee.class)
		public ResponseEntity<Employee> findEmployeeeById(@PathVariable("id") Integer id) throws EmployeeServiceException {
			return ResponseEntity.ok().body(employeeService.findEmployeeById(id));
			
	}

}


