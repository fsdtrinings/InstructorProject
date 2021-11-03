package com.mkj.test.SpringRESTHibernate.execption;

/*
 * this is normal bean class , for 
 * custom exception response
 * 
 * must contain
 * 1) HTTP error Status 
 * 2) String message
 * 
 * etc
 * */

public class CustomInstructorExceptionResponse {

	private int status;
	private String errorMsg;
	
	public CustomInstructorExceptionResponse() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CustomInstructorExceptionResponse(int status, String errorMsg) {
		super();
		this.status = status;
		this.errorMsg = errorMsg;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getErrorMsg() {
		return errorMsg;
	}
	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}
	
	
	
}//end class
