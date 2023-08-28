package com.scb.samplecrud.exception;

import java.time.LocalDateTime;

public class APIExceptionPayload {

	String message;
    int Status;
    String httpStatus;
    boolean success;
    boolean exception;
    LocalDateTime timestamp;
    String path;
    
	public APIExceptionPayload(String message, int status, String httpStatus, boolean success, boolean exception,
			LocalDateTime timestamp, String path) {
		super();
		this.message = message;
		Status = status;
		this.httpStatus = httpStatus;
		this.success = success;
		this.exception = exception;
		this.timestamp = timestamp;
		this.path = path;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public int getStatus() {
		return Status;
	}
	public void setStatus(int status) {
		Status = status;
	}
	public String getHttpStatus() {
		return httpStatus;
	}
	public void setHttpStatus(String httpStatus) {
		this.httpStatus = httpStatus;
	}
	public boolean isSuccess() {
		return success;
	}
	public void setSuccess(boolean success) {
		this.success = success;
	}
	public boolean isException() {
		return exception;
	}
	public void setException(boolean exception) {
		this.exception = exception;
	}
	public LocalDateTime getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(LocalDateTime timestamp) {
		this.timestamp = timestamp;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	@Override
	public String toString() {
		return "APIExceptionPayload [message=" + message + ", Status=" + Status + ", httpStatus=" + httpStatus
				+ ", success=" + success + ", exception=" + exception + ", timestamp=" + timestamp + ", path=" + path
				+ "]";
	}
    
    
}
