package j6.demo7.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import j6.demo7.services.UserService;

@Controller
public class AuthController {
	
	@Autowired
	private UserService userService;

	@RequestMapping("/auth/login/form")
	public String form() {
		return "auth/login";
	}
	
	@RequestMapping("/auth/login/success")
	public String success(Model model) {
		model.addAttribute("message", "Đăng nhập thành công");
		return "forward:/auth/login/form";
	}
	
	@RequestMapping("/auth/login/error")
	public String error(Model model) {
		model.addAttribute("message", "Đăng nhập thất bại");
		return "auth/login";
	}
	
	@RequestMapping("/auth/logout/success")
	public String logout(Model model) {
		model.addAttribute("message", "Đăng xuất thành công");
		return "forward:/auth/login/form";
	}
	
	@RequestMapping("/auth/access/denied")
	public String denied(Model model) {
		model.addAttribute("message", "Không có quyền truy cập");
		return "forward:/auth/login/form";
	}
	
//	7.6
	@RequestMapping("/oauth2/login/success")
	public String successOAuth2(OAuth2AuthenticationToken oauth2) {
		userService.loginFromOAuth2(oauth2);
		return "forward:/auth/logout/success";
	}
}
