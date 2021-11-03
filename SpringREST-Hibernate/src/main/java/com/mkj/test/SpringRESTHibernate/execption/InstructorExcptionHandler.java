package com.mkj.test.SpringRESTHibernate.execption;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice // this class is appied on all controllers
public class InstructorExcptionHandler {
	
	/*  This method will be responsible for 
	 * rendering custom exception response*/
	@ExceptionHandler
	public ResponseEntity<CustomInstructorExceptionResponse> abc(javax.persistence.NoResultException e)
	{	CustomInstructorExceptionResponse excptionResponse = new CustomInstructorExceptionResponse();
		excptionResponse.setStatus(HttpStatus.NOT_FOUND.value());
		excptionResponse.setErrorMsg("Invalid Id, Pls Try Again");
		
		return new ResponseEntity<>(excptionResponse, HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler
	public ResponseEntity<CustomInstructorExceptionResponse> abc(InstructorNotFoundException e)
	{
		System.out.println("\n\n ====>> Inside Exception Handler");
		
		CustomInstructorExceptionResponse excptionResponse = new CustomInstructorExceptionResponse();
		excptionResponse.setStatus(HttpStatus.NOT_FOUND.value());
		excptionResponse.setErrorMsg("Invalid Id, Pls Try Again");
		
		return new ResponseEntity<>
			(excptionResponse, HttpStatus.NOT_FOUND);
				
	}
	public InstructorExcptionHandler() {
		super();
		System.out.println("---------->> Handler Contructor");
	}

}
