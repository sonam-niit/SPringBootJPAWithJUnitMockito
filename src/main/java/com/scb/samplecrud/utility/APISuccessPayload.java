package com.scb.samplecrud.utility;

import org.springframework.http.HttpStatus;

public class APISuccessPayload {

	private String message;
    private int status;
    private String httpStatus;
    private boolean success;
    private boolean exception;
    private Object body;
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
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
	public Object getBody() {
		return body;
	}
	public void setBody(Object body) {
		this.body = body;
	}
	@Override
	public String toString() {
		return "APIPayload [message=" + message + ", status=" + status + ", httpStatus=" + httpStatus + ", success="
				+ success + ", exception=" + exception + ", body=" + body + "]";
	}
    public static APISuccessPayload build(Object body,String message,HttpStatus status) {
        APISuccessPayload payload = new APISuccessPayload();
        payload.setBody(body);
        payload.setMessage(message);
        payload.setStatus(status.value());
        payload.setHttpStatus(String.valueOf(status));
        payload.setSuccess(true);
        payload.setException(false);
        return payload;
        
    }
    
    
}
