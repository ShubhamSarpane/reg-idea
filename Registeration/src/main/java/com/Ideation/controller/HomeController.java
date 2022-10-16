package com.Ideation.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import com.Ideation.entity.Idea;
import com.Ideation.entity.employees;
import com.Ideation.helper.Message;
import com.Ideation.config.CustomUserDetails;
import com.Ideation.dao.UserRepository;

/*@Controller*/
/* @RequestMapping("/user") */

@Controller
@RequestMapping("/employees")
public class HomeController {
	
	@Autowired
	RestTemplate restTemplate;

	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	@Autowired
	UserRepository userRepository;

	// for home page
	@RequestMapping("/home")
	public String home(Model model) {

		model.addAttribute("title", "Home - IdeationPlatform");

		return "/home";
	}

	/*--------------------------------------------------------------------*/

	// for home page
	@RequestMapping("/aboutus")
	public String aboutus(Model model) {

		model.addAttribute("title", "aboutus");
		
		/*
		 * System.out.println("Step 1"); Object principal =
		 * SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		 * 
		 * int employeeid = ((CustomUserDetails)principal).getEmployeeid();
		 * System.err.println("Steo 2"+ employeeid); List<Idea> ideas=
		 * this.restTemplate.getForObject("http://localhost:9092/idea/idea/"+employeeid,
		 * List.class);
		 * 
		 * 
		 * for(Object i:ideas) {
		 * 
		 * System.out.println(i);
		 * 
		 * }
		 * 
		 * 
		 * 
		 * System.out.println(ideas.getClass());
		 */
		return "/aboutus";
	}

	/*
	 * -----------------------------------------------------------------------------
	 * --------
	 */

	// for home page
	@RequestMapping("/casestudies")
	public String casestudies(Model model) {

		model.addAttribute("title", "casestudies");

		return "/casestudies";
	}

	/*
	 * -----------------------------------------------------------------------------
	 * --------
	 */

	// for home page
	@RequestMapping("/hackathon")
	public String hackathon(Model model) {

		model.addAttribute("title", "hackathon");

		return "/hackathon";
	}

	/*
	 * -----------------------------------------------------------------------------
	 * --------
	 */

	// for home page
	@RequestMapping("/ipr")
	public String ipr(Model model) {

		model.addAttribute("title", "ipr");

		return "/ipr";
	}

	/*
	 * -----------------------------------------------------------------------------
	 * --------
	 */
	// for SignUp page

	@GetMapping("/signup")
	public String signup(Model model) {

		model.addAttribute("title", "Register - Ideation Platform");
		/* model.addAttribute("user",new employees()); */

		return "/signup";
	}

	// this handler for do registration

	@PostMapping("do_register")
	public String registerUser(@ModelAttribute("user") employees employees,
			@RequestParam(value = "agreement", defaultValue = "false") boolean agreement, Model model,
			HttpSession session) {

		try {
			/*
			 * final UserEntity customer = userRepository.findByEmail(email); if (customer
			 * == null) { throw new UsernameNotFoundException(email); }
			 */

			employees.setRole("ROLE_USER");
			/* user.setEnabled(true); */
			employees.setPassword(passwordEncoder.encode(employees.getPassword()));

			employees result = this.userRepository.save(employees);
			/* user.setPassword(passwordEncoder.encode(user.getPassword())); */

			// for success msg

			session.setAttribute("message", new Message("Successfully register!!", "success"));

		} catch (Exception e) {
			/* System.out.println("ERROR"+e.getMessage()); */
			e.printStackTrace();

			// for error msg

			session.setAttribute("message", new Message("This Email Already used!!", "danger"));

			return "/signup";

			/* System.out.println(e); */
		}

		return "redirect:/employees/signin";
	}

	/*
	 * -----------------------------------------------------------------------------
	 * --------
	 */

	// handle for custom login

	@GetMapping("/signin")
	public String customLogin(Model model) {
		model.addAttribute("title", "Login Page");
		return "/login";

	}

	/*
	 * -----------------------------------------------------------------------------
	 * --------
	 */
	
	@RequestMapping("/innovation")
	public String dashbord(Model m) {
		List<Idea>  ideas= this.restTemplate.getForObject("http://localhost:9092/idea/getall", List.class);
		
		 //shs
		  
		  List<Idea> idealist = new ArrayList<Idea>();
		  
		  Map<String, String> s;
		  
			 for(int i=0; i<ideas.size();i++) {
				 
				 s= (Map<String, String>) ideas.get(i);
				 
				 Idea temp = new Idea();
				
				 temp.setIdea_title(s.get("idea_title"));
				 temp.setLink(s.get("link"));
				 temp.setTechnology(s.get("technology"));
				 temp.setIdea_details(s.get("idea_details"));
				 
				 idealist.add(temp);
				 
			 } 
			 
			 
			 m.addAttribute("idealists", idealist);
		
		
		return "/normal/user_dashbord";
	}

}
