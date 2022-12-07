package j6.demo6.controllers;

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

	// 6.2
	@GetMapping("/home/index")
	public String home(Model model) {
		model.addAttribute("message", "Home page");
		return "home/index";
	}

	// 6.2
	@GetMapping("/home/about")
	public String about(Model model) {
		model.addAttribute("message", "About page");
		return "home/index";
	}

//	6.6
//	@PreAuthorize("hasRole('ADMIN')")
//	6.5
	@GetMapping("/home/admins")
	public String admins(Model model) {
//		6.7 kiểm tra bằng dòng lệnh
		if (!req.isUserInRole("ADMIN")) {
			return "redirect:/auth/access/denied";
		}
		model.addAttribute("message", "Admins page");
		return "home/index";
	}

//	6.6
//	@PreAuthorize("hasAnyRole('ADMIN', 'USER')")
//	6.5
	@GetMapping("/home/users")
	public String users(Model model) {
//		6.7 kiểm tra bằng dòng lệnh
		if (!(req.isUserInRole("ADMIN") || req.isUserInRole("USER"))) {
			return "redirect:/auth/access/denied";
		}
		model.addAttribute("message", "Users page");
		return "home/index";
	}

//	6.6
//	@PreAuthorize("isAuthenticated()")
//	6.5
	@GetMapping("/home/authenticated")
	public String authenticated(Model model) {
//		6.7 kiểm tra bằng dòng lệnh
		if (req.getRemoteUser() == null) {
			return "redirect:/auth/login/form";
		}
		model.addAttribute("message", "Authenticated page");
		return "home/index";
	}
	
//	6.8
	@GetMapping("/home/thymeleaf1")
	public String thymeleaf1(Model model) {
		model.addAttribute("message", "Thymeleaf - Without Extras");
		return "home/thymeleaf1";
	}
	

//	6.8
	@GetMapping("/home/thymeleaf2")
	public String thymeleaf2(Model model) {
		model.addAttribute("message", "Thymeleaf - With Extras");
		return "home/thymeleaf2";
	}
}
