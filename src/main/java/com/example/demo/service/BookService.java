package com.example.demo.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.repository.BookRepository;
import com.example.demo.repository.EmployeeRepository;
import com.example.demo.dto.EmployeeDTO;
import com.example.demo.exception.BookNotFoundException;
import com.example.demo.exception.EmployeeServiceException;
import com.example.demo.model.Book;

@Service
public class BookService {
	@Autowired
	BookRepository bookRepository;
	@Autowired
	EmployeeRepository employeeRepository;
	
	

	public List<Book> getAllBooks() {
		List<Book> bookList = new ArrayList<>();
		bookList = bookRepository.findAll();
		// .forEach(bookList::add);
		return bookList;
	}

	public Book getBookById(Integer id) throws BookNotFoundException {
		Book book = bookRepository.findBookById(id);
		if(book==null) {
			throw new BookNotFoundException("Book Not Found");
		}
		return book;

	}
	 public Optional<Book> findById(int id) throws BookNotFoundException {

         // TODO Auto-generated method stub

         Optional<Book> book = bookRepository.findById(id);

         if (book.isPresent()) {

                         return book;

         } else {

                         throw new BookNotFoundException("Book Not found");

         }

}
	
	/*public Book getBookById(Integer id) throws EmployeeNotFoundException {
		Book book = (Book) bookRepository.findBookById(id);
		return book;

	}*/
	public Book addBook(Book book) {

		return bookRepository.save(book);
	}

	public void deleteBook(Integer id) {
		bookRepository.deleteById(id);
	}

	public void updateBook(Integer id, Book book) {
		bookRepository.save(book);
	}
	
	
	


}