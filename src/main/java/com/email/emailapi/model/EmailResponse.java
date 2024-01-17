package com.email.emailapi.model;

import lombok.Data;

@Data
public class EmailResponse {

	private String token;
	public EmailResponse(String token) {
		this.token=token;
	}
}
