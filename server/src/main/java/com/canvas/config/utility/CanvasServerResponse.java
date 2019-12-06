package com.canvas.config.utility;

import org.springframework.stereotype.Component;

@Component
public class CanvasServerResponse<T> {
	
	private String statusCode;
	private String statusMessage;
	private T response;
	public String getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}
	public String getStatusMessage() {
		return statusMessage;
	}
	public void setStatusMessage(String statusMessage) {
		this.statusMessage = statusMessage;
	}
	public T getResponse() {
		return response;
	}
	public void setResponse(T response) {
		this.response = response;
	}
	public void reset() {
		this.statusCode="";
		this.statusMessage="";
		this.response=null;
		
	}
}
