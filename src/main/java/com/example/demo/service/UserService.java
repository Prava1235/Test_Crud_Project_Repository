package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.exception.BookNotFoundException;
import com.example.demo.exception.UserNotFoundException;
import com.example.demo.model.Book;
import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;

@Service
public class UserService {
	@Autowired
	UserRepository userRepository;
	
	

	public List<User> getAllUsers() {
		List<User> userList = new ArrayList<>();
		userList = userRepository.findAll();
		// .forEach(bookList::add);
		return userList;
	}

	public User getUserById(Integer id) throws UserNotFoundException {
		User user = userRepository.findUserById(id);
		if (user == null) {
			throw new UserNotFoundException("User Not Found");
		}
		return user;

	}

	public Optional<User> findById(int id) throws UserNotFoundException {

		// TODO Auto-generated method stub

		Optional<User> user = userRepository.findById(id);

		if (user.isPresent()) {

			return user;

		} else {

			throw new UserNotFoundException("User Not found");

		}

	}

	/*
	 * public Book getBookById(Integer id) throws EmployeeNotFoundException { Book
	 * book = (Book) bookRepository.findBookById(id); return book;
	 * 
	 * }
	 */
	public User addUser(User user) {

		return userRepository.save(user);
	}

	public void deleteUser(Integer id) {
		userRepository.deleteById(id);
	}

	public void updateUser(Integer id, User user) {
		userRepository.save(user);
	}

}
