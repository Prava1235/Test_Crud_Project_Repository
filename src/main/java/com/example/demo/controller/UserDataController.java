package com.example.demo.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.User;
import com.example.demo.repository.AuditRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.AuditService;
import com.example.demo.service.UserDataService;
import com.example.demo.service.UserService;

import io.swagger.annotations.ApiOperation;

@RestController
public class UserDataController {
	private static final Logger logger = LoggerFactory.getLogger(BookController.class);
	@Autowired
	UserService userService;
	@Autowired
	AuditService auditService;
	@Autowired
	UserDataService userDataService;

	@Autowired
	UserRepository userRepository;
	@Autowired
	AuditRepository auditRepository;

	@RequestMapping(value = "/userdatas/{id}", method = RequestMethod.DELETE)
	@ApiOperation(value = "Delete the UserData By Id", notes = "Provide the Userid  and  Delete the User Info for a given Userid ", response = User.class)
	public ResponseEntity<Object> deleteUser(@PathVariable("id") Integer id) {
		
	
			userDataService.deleteUserData(id);
			// LocalTime startTime = LocalTime.now(ZoneId.systemDefault());
			// LocalTime endTime = LocalTime.MIDNIGHT.minusMinutes(1);

			
			return new ResponseEntity<>("User is deleted successsfully", HttpStatus.OK);

	}

	/*@RequestMapping(value = "/users/{id}", method = RequestMethod.PUT)
	@ApiOperation(value = "Update the User By Id", notes = "Provide the Userid  and  Update the user Info for a given userid ", response = User.class)
	public ResponseEntity<Object> updateUser(@PathVariable("id") Integer id, @RequestBody User user) {
		String userrole = userRepository.findUserRoleById(id);

		if (userrole.equalsIgnoreCase("ADMIN")) {
			userService.updateUser(id, user);
			Timestamp stamp = new Timestamp(System.currentTimeMillis());
			stamp.setNanos((int) (System.nanoTime() % 1000000000));
			Audit audit = new Audit();
			audit.setStartTimeOfAction(stamp);
			audit.setEndTimeOfAction(stamp);
			audit.setTypeOfAction("UPDATE");
			auditService.addAudit(audit);

			return new ResponseEntity<>("User is updated successsfully", HttpStatus.OK);
		} else
			return new ResponseEntity<>("User is not having Accee to this methods", HttpStatus.BAD_REQUEST);
	}

	@RequestMapping(value = "/users", method = RequestMethod.POST)
	@ApiOperation(value = "Add User", notes = "Adding User Info ", response = User.class)
	public ResponseEntity<User> addUser(@RequestBody User user) {

		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(user.getUserId())
				.toUri();
		//Integer pathid = user.getUserId();

		// ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}");
		String userrole = userRepository.findUserRoleById(user.getUserId());
		// String userrole = userRepository.findUserRoleById();
		if (userrole.equalsIgnoreCase("ADMIN")) {
			Timestamp stamp = new Timestamp(System.currentTimeMillis());
			stamp.setNanos((int) (System.nanoTime() % 1000000000));
			Audit audit = new Audit();
			audit.setStartTimeOfAction(stamp);
			audit.setEndTimeOfAction(stamp);
			audit.setTypeOfAction("CREATE");
			auditService.addAudit(audit);

			return ResponseEntity.created(uri).body(userService.addUser(user));
		} else
			return ResponseEntity.badRequest().body(userService.addUser(user));
	}

	@RequestMapping(value = "/users", method = RequestMethod.GET)
	public ResponseEntity<List<User>> getAllUsers() {
		userService.getAllUsers();
		return ResponseEntity.ok().body(userService.getAllUsers());

	}

	@RequestMapping(value = "/users/{id}", method = RequestMethod.GET)
	public ResponseEntity<User> getUserById(@PathVariable("id") Integer id) throws UserNotFoundException {
		String userrole = userRepository.findUserRoleById(id);

		if (userrole.equalsIgnoreCase("ADMIN")) {
			Timestamp stamp = new Timestamp(System.currentTimeMillis());
			stamp.setNanos((int) (System.nanoTime() % 1000000000));
			Audit audit = new Audit();
			audit.setStartTimeOfAction(stamp);
			audit.setEndTimeOfAction(stamp);
			audit.setTypeOfAction("READ");
			auditService.addAudit(audit);

			return ResponseEntity.ok().body(userService.getUserById(id));
		} else
			return ResponseEntity.badRequest().body(userService.getUserById(id));
	}
	*/
}