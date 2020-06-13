package com.example.demo.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpHeaders;
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
import com.example.demo.model.Employee;
import com.example.demo.repository.EmploySortingRepository;
import com.example.demo.repository.EmployeeRepository;
import com.example.demo.model.Book;
import com.example.demo.service.BookService;
import com.example.demo.service.EmployeePageingAndSortingService;
import com.example.demo.service.EmployeeService;

import io.swagger.annotations.ApiOperation;

@RestController
public class EmployeePageingAndSortingController {
	@Autowired
	EmployeePageingAndSortingService employeePageingAndSortingService;
	@Autowired
	EmploySortingRepository employSortingRepository;

	@RequestMapping(value = "/employeesortandpageings", method = RequestMethod.GET)
	public ResponseEntity<List<Employee>> getAllEmployees(@RequestParam(defaultValue = "0") Integer pageNo,
			@RequestParam(defaultValue = "10") Integer pageSize, @RequestParam(defaultValue = "id") String sortBy) {
		List<Employee> list = employeePageingAndSortingService.getAllEmployees(pageNo, pageSize, sortBy);

		return new ResponseEntity<List<Employee>>(list, new HttpHeaders(), HttpStatus.OK);
	}

}


/*@RequestMapping(value = "/employeesortandpageings",method = RequestMethod.GET)
public Page<Employee> getEmpYearOfExpCount(@RequestParam(defaultValue = "0") int pageNo, 
@RequestParam(defaultValue = "10") int pageSize,
@RequestParam(defaultValue = "id") String sortBy) {
Pageable paging = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));
  return employSortingRepository.findAll(paging);
 }*/