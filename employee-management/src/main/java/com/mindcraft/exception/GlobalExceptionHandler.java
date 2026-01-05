package com.mindcraft.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import lombok.Data;

import java.time.LocalDateTime;

@RestControllerAdvice
@Data
public class GlobalExceptionHandler {

    @ExceptionHandler(BaseException.class)
    public ResponseEntity<ErrorResponse> handleBaseException(BaseException ex) {

        ErrorResponse error = new ErrorResponse();
        error.setStatus(ex.getStatus().value());
        error.setMessage(ex.getMessage());
        error.setTimestamp(LocalDateTime.now());
                

        return new ResponseEntity<>(error, ex.getStatus());
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleGenericException(Exception ex) {


        ErrorResponse error = new ErrorResponse();
        error.setStatus(500);
        error.setMessage("Internal Server Error");
        error.setTimestamp(LocalDateTime.now());
    	
 

        return ResponseEntity.internalServerError().body(error);
    }
}
