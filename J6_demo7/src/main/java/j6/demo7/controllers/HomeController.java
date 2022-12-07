package j6.demo7.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
	
	@Autowired
	private HttpServletRequest req;

	@GetMapping("/home/index")
	public String home(Model model) {
		model.addAttribute("message", "Home page");
		return "home/index";
	}

	@GetMapping("/home/about")
	public String about(Model model) {
		model.addAttribute("message", "About page");
		return "home/index";
	}
	
	@GetMapping("/home/admins")
	public String admins(Model model) {
		model.addAttribute("message", "Admins page");
		return "home/index";
	}
	
	@GetMapping("/home/users")
	public String users(Model model) {
		model.addAttribute("message", "Users page");
		return "home/index";
	}

	@GetMapping("/home/authenticated")
	public String authenticated(Model model) {
		model.addAttribute("message", "Authenticated page");
		return "home/index";
	}
}
