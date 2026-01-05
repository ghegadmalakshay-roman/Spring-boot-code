package com.mindcraft.exception;

import lombok.*;

import java.time.LocalDateTime;


public class ErrorResponse {

    private int status;
    private String message;
    private LocalDateTime timestamp;
    
    
    
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public LocalDateTime getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(LocalDateTime timestamp) {
		this.timestamp = timestamp;
	}
	@Override
	public String toString() {
		return "ErrorResponse [status=" + status + ", message=" + message + ", timestamp=" + timestamp + "]";
	}
    
    
}
