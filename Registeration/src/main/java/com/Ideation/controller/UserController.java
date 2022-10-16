package com.Ideation.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;


import com.Ideation.config.CustomUserDetails;
import com.Ideation.entity.Idea;



@Controller
@RequestMapping("/user")
public class UserController {
	
	
	
	@Autowired
	private RestTemplate restTemplate;
	
	  //for enter innovation ideas
	  @RequestMapping("/enterYourInnovationIdeas") 
	  public String enterYourInnovationIdeas() { 
		  
		  Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		  
		  int employeeid = ((CustomUserDetails)principal).getEmployeeid();
		  
		  
		  


		  
		  
		  
		  return "/normal/addidea";
		
	  }
	 
	
		/*-----------------------------------------------------------------------*/
	  
	  
	  
	  
	//for enter innovation ideas
	  @RequestMapping("/knowyourInnovationIdeaStatus") 
	  public String knowyourInnovationIdeaStatus(Model m) { 
		  System.out.println("Stpe1");
          Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		  
		  int employeeid = ((CustomUserDetails)principal).getEmployeeid();
		  System.out.println("Step2");
		  List<Idea>  ideas= this.restTemplate.getForObject("http://localhost:9092/idea/idea/"+employeeid, List.class);
		  
		  System.out.println(ideas);
		  
		  
		  Map<String, String> j;
		  
		 for(int i=0; i<ideas.size();i++) {
			 
			 j= (Map<String, String>) ideas.get(i);
			 
			 System.out.println(j.get("idea_title"));
		 } 
		  
		  System.out.println("step 3");
		  
		  //shs
		  
		  List<Idea> idealist = new ArrayList<Idea>();
		  
		  Map<String, String> s;
		  
			 for(int i=0; i<ideas.size();i++) {
				 
				 s= (Map<String, String>) ideas.get(i);
				 
				 Idea temp = new Idea();
				 temp.setEmployeeid(employeeid);
				 temp.setIdea_title(s.get("idea_title"));
				 temp.setLink(s.get("link"));
				 temp.setTechnology(s.get("technology"));
				 temp.setIdea_details(s.get("idea_details"));
				 
				 idealist.add(temp);
				 
			 } 
			 
			 
			 m.addAttribute("idealists", idealist);
		 
		  
		  return "/normal/know_yourInnovationIdeaStatus";
	
	  }
	

		/*-----------------------------------------------------------------------*/
	
	// this handler for do registration

		@PostMapping("add_idea")
		public String registerUser(@ModelAttribute("idea") Idea idea) {

			try {
				 Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
				  
				  int employeeid = ((CustomUserDetails)principal).getEmployeeid();
				  
				   idea.setEmployeeid(employeeid);
				// save idea in ideaservice
				   
				   
				   	  HttpHeaders headers = new HttpHeaders();	
				      headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
				      HttpEntity<Idea> entity = new HttpEntity<Idea>(idea,headers);
				      
				      String response= restTemplate.exchange("http://localhost:9092/idea/saveidea", HttpMethod.POST, entity, String.class).getBody();
				   
				   System.out.println(response);

			//	employees result = this.userRepository.save(employees);
			
				

			} catch (Exception e) {
				
				e.printStackTrace();


			}

			return "/normal/addidea";
		}

}

