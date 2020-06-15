package com.example.demo;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookController {
	@Autowired
	BookService bookService;
	
@GetMapping("/book")
public List<Book> getAllBooks() {
		List<Book> bookList=null;
		bookList=bookService.getAllBooks();
		return bookList;
}
	@PostMapping("/book")
	public Book createBooks(@RequestBody Book book) {
			return bookService.createBooks(book);
	}
	
}