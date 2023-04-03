package com.ecommerce.ecommerce.payload.reponse;

import java.time.LocalDateTime;

public class MessageResponse {
	private final boolean success;
	private String message;

	public MessageResponse(boolean success, String message) {
		this.success = success;
		this.message = message;
	}

	public boolean isSuccess() {
		return success;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	public String getTimestamp() {
		return LocalDateTime.now().toString();
	}
}
