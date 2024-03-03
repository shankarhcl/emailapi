package com.email.emailapi.service;

import java.util.Properties;

import org.springframework.stereotype.Service;

import jakarta.mail.Authenticator;
import jakarta.mail.Message;
import jakarta.mail.PasswordAuthentication;
import jakarta.mail.Session;
import jakarta.mail.Transport;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;

@Service
public class EmailService {
	
	public boolean sendEmail(String subject, String message, String to) {
	       
		    boolean flag = false;
		    String from = "s@gmail.com";
       	   System.out.println( "Preparing to send message..." );    	
		   Properties properties = System.getProperties();
	       System.out.println( "properties: "+properties );
	       
	       // Step1: configure SMTP server details
	       properties.put("mail.smtp.host", "smtp.gmail.com");
	       properties.put("mail.smtp.port", "587");
	       properties.put("mail.smtp.starttls.enable", true);
	       properties.put("mail.smtp.auth", true);
	      
	       //Step2: to get session object
	       final String username = "s@gmail.com";
	       final String password = "tohmcvzbjfeybmbu";
	       System.out.println( "going to get session....." );
	       Session session= Session.getInstance(properties, new Authenticator() {  
	    	    @Override
	    	     protected PasswordAuthentication getPasswordAuthentication() {
	    		 return new PasswordAuthentication(username,password);
	    	  }
		   });  
	       System.out.println( "email authenticated...." );

	       //Step3: compose the messsage
	       Message msg = new MimeMessage(session);
	       System.out.println( "going to set message params" );
	       try {	
	    	//Step4: set to,from,message,subject
	    	   msg.setFrom(new InternetAddress(from));
	    	   msg.setRecipient(Message.RecipientType.TO, new InternetAddress(to));
	    	   msg.setSubject(subject);
	    	   msg.setText(message);
		       System.out.println( "mime msg: "+ msg );

	           //Step5: send message using Transport class
	           Transport.send(msg);
	           System.out.println( "message sent successfully..." );
	           flag = true;
	       }catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}
}
