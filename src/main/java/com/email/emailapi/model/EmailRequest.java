package com.email.emailapi.model;

import lombok.Data;

@Data
public class EmailRequest {

	String to;
	String subject;
	String message;
}
