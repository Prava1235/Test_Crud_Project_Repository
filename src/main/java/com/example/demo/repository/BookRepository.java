package com.example.demo.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {
	
	@Query("select b from Book b where b.bookid = ?1")
	Book findBookById(Integer id);
	
	

}


	
	/*@Query(value="select new com.example.demo.dto.EmployeeDTO(emp. yearOfExp,count(*)) from Employee emp group by  yearOfExp")
	public List< EmployeeDTO> getEmpYearOfExpCount();

}*/
