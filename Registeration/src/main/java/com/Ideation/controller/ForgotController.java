package com.Ideation.controller;

import java.util.Properties;
import java.util.Random;

import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpSession;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.Ideation.dao.UserRepository;
import com.Ideation.entity.employees;
import com.Ideation.service.EmailSenderService;

@Controller
public class ForgotController {
	Random random = new Random(1000);
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private BCryptPasswordEncoder bcrypt;

	
	  @Autowired 
	  private com.Ideation.service.service emailService;
	 

	@Autowired
	private EmailSenderService service;

	// for forgotpass email id

	@RequestMapping("/forgot")
	public String openEmailForm() {

		return "/forgot_email_form";
	}

	@PostMapping("/send-otp")
	public String sendotp(@RequestParam("email") String email, HttpSession session) {

		System.out.println("Email" + email);

		// genration otp 4 digit

		int otp = random.nextInt(999999);

		System.out.println("OTP :" + otp);

		
		  //write code for send otp
		  String subject="OTP From Innovation portal"; 
		  String message= "otp"+otp ;
		  String to = email;
		  
		
	
		  
			 this.service.sendSimpleEmail(to, message, subject); 
		 
		 session.setAttribute("myotp", otp);
		 session.setAttribute("email", email);

		 return "verify_otp"; 
	}
	
	
	///verify-otp
	
	@PostMapping("/verify-otp")
	public String verifyotp(@RequestParam("otp") int otp,HttpSession session) {
		
	    int  myotp=	(int)session.getAttribute("myotp");
	    String email= (String)session.getAttribute("email");
		
	    if(myotp==otp) {
	    	
	    	//password change
	    employees employees=this.userRepository.getUserByUserName(email);
	    	
	    
	    if (employees==null) {
	    	
	    	return "forgot_email_form";
			
		} else {
			
			
			
			return "password_change_form";

		}
	    
	    
	    
	    }else {
			
	    	
	    	
	    	
	    	return "verify_otp";
		}
	    
	    
		
	}
	
	//change password
	
	@PostMapping("/change-password")
	public String changePassword(@RequestParam("newpassword") String newpassword,HttpSession session ) {
		
		String email= (String)session.getAttribute("email");
		com.Ideation.entity.employees employees = this.userRepository.getUserByUserName(email);
		employees.setPassword(this.bcrypt.encode(newpassword));
		this.userRepository.save(employees);
		
		
		
		return "redirect:/employees/signin";
	}
	
	
	
	
	

}


















































/*this.service.sendSimpleEmail(toEmail: "email", body: "otp", subject:*/
/* "OTP from Innovation portal"); */



/* return "verify_otp"; */

/*
 * boolean flag = this.emailService.sendEmail(subject, message, to);
 * 
 * 
 * if(flag) {
 * 
 * 
 * return "/verify_otp"; }else {
 * 
 * session.setAttribute("message", "check your email id!!");
 * 
 * return"/forgot_email_form"; }
 */

