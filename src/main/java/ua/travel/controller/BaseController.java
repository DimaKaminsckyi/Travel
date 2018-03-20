package ua.travel.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BaseController {
	
	@GetMapping({"/", "/home"})
	public String shoHome() {
		return "home";
	}
}