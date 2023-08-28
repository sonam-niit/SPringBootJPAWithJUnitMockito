package com.scb.samplecrud.exception;

import java.time.LocalDateTime;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.server.ResponseStatusException;

@ControllerAdvice
public class APIExceptionHandler {

	@ExceptionHandler(value= {ResponseStatusException.class})
    public ResponseEntity<Object> handleAPIException(ResponseStatusException e,WebRequest request){
        
        String path = request.getDescription(false).replace("url=", "");
        
        //1 Creating a payload with exception details
        
        APIExceptionPayload payload = new APIExceptionPayload(e.getMessage(),
                                                                e.getStatus().value(),
                                                                String.valueOf(e.getStatus()),
                                                                false,
                                                                true,
                                                                LocalDateTime.now(),
                                                                path);
        //2. Returning the response entity
        return new ResponseEntity<Object>(payload,e.getStatus());
    }
}
