package ua.travel.controller;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import ua.travel.entity.Tour;
import ua.travel.service.TourService;

@Controller
public class TourController {
	
	@Autowired private TourService tourService;
	
	@GetMapping("/tours/{pageNumber}")
	public String showTours(@PathVariable("pageNumber") int pageNumber,Model model) {
		Page<Tour> page = tourService.getPagebleTour(pageNumber, 6, "ASC", "id");
		
		int currentPage = page.getNumber() + 1;
		int begin = Math.max(1, currentPage - 10);
		int end = Math.min(begin + 10, page.getNumber());
		
		model.addAttribute("tourList", page);
		model.addAttribute("beginIndex", begin);
		model.addAttribute("endIndex", end);
		model.addAttribute("currentIndex", currentPage);
		model.addAttribute("tourListByPageSize", page.getContent());
		//model.addAttribute("tourListByPageSize", tourService.findAllTours() );
		return "tours";
	}

}
