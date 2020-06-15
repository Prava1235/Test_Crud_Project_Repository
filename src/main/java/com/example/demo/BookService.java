package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import com.example.demo.BookRepository;
@Service
public class BookService {
	@Autowired
	BookRepository bookRepository;
	
	public List<Book> getAllBooks() {
		List<Book> bookList=null;
		bookList=bookRepository.findAll();
		return bookList;
}
	
	public Book createBooks(Book book) {
		
		return (Book)bookRepository.save(book);
	}
	

}
