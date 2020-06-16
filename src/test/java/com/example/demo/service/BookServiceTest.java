package com.example.demo.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.exception.BookNotFoundException;
import com.example.demo.model.Book;
import com.example.demo.repository.BookRepository;

public class BookServiceTest {
	@InjectMocks
	BookService bookService;
	@Mock

    BookRepository bookRepository;


    @Before

    public void init() {

        MockitoAnnotations.initMocks(this);

    }

    

    @Test

    public void getAllBooksTest()

    {

        List<Book> list = new ArrayList<Book>();

        Book book1 = new Book(1, "Java8","Wilson1");

        Book book2 = new Book(2, "Java9","Wilson2");

        Book book3 = new Book(3, "Java10","Wilson3");

        

        list.add(book1);

        list.add(book2);

        list.add(book3);

        

        when(bookRepository.findAll()).thenReturn(list);

        

        //test

        List<Book> bookList = bookService.getAllBooks();

        

        assertEquals(3, bookList.size());

        verify(bookRepository, times(1)).findAll();

    }

    

    @Test

    public void getBookByIdTest() throws BookNotFoundException

    {

       Optional<Book> e1=Optional.of(new Book(1, "Java8","Wilson1"));

        when(bookRepository.findById(1)).thenReturn(e1);
        

        Optional<Book> book = bookService.findById(1);

        

        assertEquals("Java8", book.get().getBookname());

        assertEquals("Wilson1", book.get().getAuthor());

       

    }

}    
