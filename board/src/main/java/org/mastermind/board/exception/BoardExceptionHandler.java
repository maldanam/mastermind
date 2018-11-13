package org.mastermind.board.exception;

import org.mastermind.board.exception.GameNotFoundException;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class BoardExceptionHandler extends ResponseEntityExceptionHandler {
 
    @ExceptionHandler(value = { GameNotFoundException.class })
    protected ResponseEntity<Object> handleConflict(Exception ex, WebRequest request) {
    	
        String bodyOfResponse = ex.getMessage();
        
        return handleExceptionInternal(ex, 
        		bodyOfResponse, 
        		new HttpHeaders(), 
        		HttpStatus.CONFLICT, 
        		request);
    }
}