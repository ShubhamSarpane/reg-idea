package com.Ideation.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.Ideation.helper.Message;


@Service
public class EmailSenderService {
	
	@Autowired
	private JavaMailSender mailSender;
	
	public void sendSimpleEmail(String toEmail, String body, String subject) {
		
		SimpleMailMessage message = new SimpleMailMessage();
	
			message.setFrom("innovationest123@gmail.com");
			message.setTo(toEmail);
			message.setText(body);
			message.setSubject(subject);
			
			
			mailSender.send(message);
			System.out.println("mail send.......");
		
		
		
	}
	
	

}
