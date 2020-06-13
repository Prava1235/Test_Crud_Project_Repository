package com.example.demo.exception;


import javax.servlet.http.HttpServletRequest;
import com.example.demo.exception.ExceptionResponse;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class EmployeeExceptionControllerAdvice extends ResponseEntityExceptionHandler {
   @ExceptionHandler(value = BookNotFoundException.class)
   public ResponseEntity<Object> exception(BookNotFoundException exception) {
      return new ResponseEntity<>("Book not found", HttpStatus.NOT_FOUND);
   }
   @ExceptionHandler(Exception.class)
	@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
	public @ResponseBody ExceptionResponse handleException(final Exception exception,
			final HttpServletRequest request) {

		ExceptionResponse error = new ExceptionResponse();
		error.setErrorMessage(exception.getMessage());
		error.callerURL(request.getRequestURI());

		return error;
	}
   @ExceptionHandler(EmployeeServiceException.class)
	public ResponseEntity<EmployeeResponse> mapException(EmployeeServiceException ex) {
		EmployeeResponse error = new EmployeeResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(),ex.getMessage());
			return new ResponseEntity<EmployeeResponse>(error,HttpStatus.INTERNAL_SERVER_ERROR);
	}
}








/*@ControllerAdvice
public class EmployeeExceptionControllerAdvice {
   @ExceptionHandler(value = EmployeeNotFoundException.class)
   public ResponseEntity<Object> exception(EmployeeNotFoundException exception) {
      return new ResponseEntity<>("Employee not found", HttpStatus.NOT_FOUND);
   }*/