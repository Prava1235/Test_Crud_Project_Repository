package com.example.demo.model;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.annotation.*;
//import org.hibernate.annotations.*;
//import com.sun.istack.NotNull;

import io.swagger.annotations.ApiModelProperty;

@Table(name = "Book")
@Entity
public class Book {
	public Book(int bookid, String bookname, String author) {
		super();
		this.bookid = bookid;
		this.bookname = bookname;
		this.author = author;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int bookid;
	@ApiModelProperty(notes="The Employee Name")
	@NotEmpty(message="Employee name cann't be blank")
	@Column
	private String bookname;
	@NotNull
	@Column
	private String author;

	public int getBookid() {
		return bookid;
	}

	public void setBookid(int bookid) {
		this.bookid = bookid;
	}

	public String getBookname() {
		return bookname;
	}

	public void setBookname(String bookname) {
		this.bookname = bookname;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public Book() {
	}

}
