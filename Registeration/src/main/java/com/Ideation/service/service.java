package com.Ideation.service;


import org.springframework.stereotype.Service;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;


@Service
public class service {
	
	
	
	//this is responsible for email send
	public static boolean sendEmail(String subject, String message, String to) {
		
		//rest of the code
		
		boolean f = false;
		
		String from = "innovationest123@gmail.com";
		
		
		
		
		//variable for gmail
		String host="smtp.gmail.com";
		
		//get the system property
		Properties properties= new Properties();
		
		//setting imp info to properties obj
		properties.put("mail.smtp.host", host);
		properties.put("mail.smtp.port", "587");
		properties.put("mail.smtp.ssl.enable", "true");
		properties.put("mail.smtp.auth", "true");
		
		//step1 to get the session obj
		
		Session session=Session.getInstance(properties, new Authenticator() {

			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				
				return new PasswordAuthentication("innovationest123@gmail.com","Test@123");
			}
			
			
			
		});
		
		/* session.setDebug(true); */ 
		
		//step2 compose the message
		MimeMessage m = new MimeMessage(session);
		
		try {
			//from email
			m.setFrom(from);
			
			
			//adding recipient to message
			m.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
			
			//adding sub to message
			m.setSubject(subject);
			
			//adding text to message
			m.setText(message);
			
			//send
			
			
			//step 3 send msg using transport class
			Transport.send(m);
			
			System.out.println("sent msg succesfully...........");
			f=true;
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return f;
		
		
	}

	
	
	
}
