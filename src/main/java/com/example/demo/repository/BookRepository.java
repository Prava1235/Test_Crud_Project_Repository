package com.example.demo.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.dto.EmployeeDTO;
import com.example.demo.model.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {
	
	@Query("select u from Book u where u.bookid = ?1")
	Book findBookById(Integer id);
	
	

}


	
	/*@Query(value="select new com.example.demo.dto.EmployeeDTO(emp. yearOfExp,count(*)) from Employee emp group by  yearOfExp")
	public List< EmployeeDTO> getEmpYearOfExpCount();

}*/
