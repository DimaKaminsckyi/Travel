package ua.travel.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import ua.travel.service.TourService;

@Controller
public class TourInfoController {

	@Autowired private TourService tourService;
	
	@GetMapping("/{tourId}/tour-info")
	public String showTourInfo(@PathVariable("tourId") int tourId , Model model) {
		
		model.addAttribute("tour", tourService.findTourById(tourId));
		return "tour-info";
	}
	
}
