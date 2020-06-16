package com.example.demo.controller;

import java.net.URI;
import java.util.List;

import org.apache.commons.logging.Log;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.demo.dto.EmployeeDTO;
import com.example.demo.exception.BookNotFoundException;
import com.example.demo.model.Employee;

import com.example.demo.model.Book;
import com.example.demo.service.BookService;

import io.swagger.annotations.ApiOperation;

@RestController
public class BookController {
	private static final Logger logger = LoggerFactory.getLogger(BookController.class);
	@Autowired
	BookService bookService;

	@RequestMapping(value = "/books/{id}", method = RequestMethod.DELETE)
	@ApiOperation(value = "Delete the Book By Id", notes = "Provide the Bookid  and  Delete the Book Info for a given Bookid ", response = Book.class)
	public ResponseEntity<Object> deleteBook(@PathVariable("id") Integer id) {
		bookService.deleteBook(id);
		logger.debug("Request {}",id);
		if (id.equals(8)) {
			throw new RuntimeException("Opps exceptionraised");
		}
		String response="Hi"+id +"Welcome";
		logger.debug("Response {}",response);
		logger.info("this is a delete book by id opration");
		logger.warn("Book id should not be null");
		logger.error("If Book Id is not there it will throws error message");
		return new ResponseEntity<>("Book is deleted successsfully", HttpStatus.OK);
	}

	@RequestMapping(value = "/books/{id}", method = RequestMethod.PUT)
	@ApiOperation(value = "Update the Book By Id", notes = "Provide the Bookid  and  Update the Book Info for a given Bookid ", response = Book.class)
	public ResponseEntity<Object> updateBook(@PathVariable("id") Integer id, @RequestBody Book book) {
		bookService.updateBook(id, book);
		return new ResponseEntity<>("Book is updated successsfully", HttpStatus.OK);
	}

	@RequestMapping(value = "/books", method = RequestMethod.POST)
	@ApiOperation(value = "Add Book", notes = "Adding Book Info ", response = Book.class)
	public ResponseEntity<Book> addBook(@RequestBody Book book) {
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(book.getBookid())
				.toUri();
		return ResponseEntity.created(uri).body(bookService.addBook(book));
	}

	@RequestMapping(value = "/books", method = RequestMethod.GET)
	@ApiOperation(value = "Find All Books", notes = "Get All Books Info ", response = Book.class)
	public ResponseEntity<List<Book>> getAllBook() {
		bookService.getAllBooks();
		return ResponseEntity.ok().body(bookService.getAllBooks());

	}

	@RequestMapping(value = "/books/{id}", method = RequestMethod.GET)
	@ApiOperation(value = "Find the Book By Id", notes = "Provide the Bookid  to get the Book Info for a given Bookid ", response = Book.class)
	public ResponseEntity<Book> getBookById(@PathVariable("id") Integer id) throws BookNotFoundException {
		return ResponseEntity.ok().body(bookService.getBookById(id));
	}

}
