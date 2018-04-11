package ua.travel.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ua.travel.domain.LoginRequest;

@Controller
public class LoginController {

	@GetMapping("/login")
	public String showLoginPage(Model model) {
		
		model.addAttribute("loginPage", new LoginRequest());
		return "admin/login";
	}
	
	
}
