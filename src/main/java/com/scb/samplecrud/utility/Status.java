package com.scb.samplecrud.utility;

public class Status {

	public static final String SUCCESS = "SUCCESS";
	public static final String NOT_FOUND = "NOT_FOUND";
	public static final String EXCEPTION = "EXCEPTION";
	public Status() {
		// TODO Auto-generated constructor stub
	}
	public static String getSuccess() {
		return SUCCESS;
	}
	public static String getNotFound() {
		return NOT_FOUND;
	}
	public static String getException() {
		return EXCEPTION;
	}
	@Override
	public String toString() {
		return "Status [getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
				+ "]";
	}

	
}
