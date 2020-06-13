package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;

import com.example.demo.repository.EmploySortingRepository;
import java.util.ArrayList;
import java.util.Arrays;
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
import com.example.demo.model.Book;
import com.example.demo.model.Employee;
import java.net.URI;
import java.util.List;

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
import com.example.demo.model.Employee;
import com.example.demo.repository.EmployeeRepository;
import com.example.demo.model.Book;
import com.example.demo.service.BookService;
import com.example.demo.service.EmployeeService;

import io.swagger.annotations.ApiOperation;

@Service
public class EmployeePageingAndSortingService {
	@Autowired
	EmploySortingRepository employSortingRepository;

	public List<Employee> getAllEmployees(Integer pageNo, Integer pageSize, String sortBy) {
		
		Pageable paging = PageRequest.of(pageNo, pageSize, Sort.by("empName").ascending()); 
		 
		Page<Employee> pagedResult = employSortingRepository.findAll(paging);
		
		if (pagedResult.hasContent()) {
			return pagedResult.getContent();
		} else {
			return new ArrayList<Employee>();
		}
	}
}