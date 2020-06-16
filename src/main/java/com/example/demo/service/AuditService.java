package com.example.demo.service;

import com.example.demo.model.Audit;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.repository.AuditRepository;
import com.example.demo.repository.BookRepository;
import com.example.demo.repository.EmployeeRepository;
import com.example.demo.dto.EmployeeDTO;
import com.example.demo.exception.BookNotFoundException;
import com.example.demo.exception.EmployeeServiceException;


@Service
public class AuditService {
	@Autowired
	AuditRepository auditRepository;
	
	public Audit addAudit(Audit audit) {

		return auditRepository.save(audit);
	}

}
