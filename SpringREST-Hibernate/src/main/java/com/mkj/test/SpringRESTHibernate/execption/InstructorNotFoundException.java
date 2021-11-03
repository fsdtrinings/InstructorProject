package com.mkj.test.SpringRESTHibernate.execption;
/*  Custome Exception*/

public class InstructorNotFoundException extends Exception{

	public InstructorNotFoundException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public InstructorNotFoundException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public InstructorNotFoundException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public InstructorNotFoundException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public InstructorNotFoundException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

	// ..... we can add some more code for exception here ...
}
