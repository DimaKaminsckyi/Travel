package ua.travel.controller;

import java.io.IOException;
import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

import ua.travel.entity.Tour;
import ua.travel.service.TourService;
import ua.travel.service.utils.CustomFileUtils;

@Controller
public class TourController {
	
	@Autowired private TourService tourService;
	
	@GetMapping("/tours/{pageNumber}")
	public String showTours(@PathVariable("pageNumber") int pageNumber,Model model) throws IOException {
		Page<Tour> page = tourService.getPagebleTour(pageNumber, 6, "ASC", "id");
		
		
		int currentPage = page.getNumber() + 1;
		int begin = Math.max(1, currentPage - 10);
		int end = Math.min(begin + 10, page.getNumber());
		
		for (Tour tour : page) {
			String imgPath = tour.getImagePath();
			tour.setImagePath(CustomFileUtils.getImage("tour_" + tour.getId(), tour.getImagePath()));
		}
		
		model.addAttribute("tourList", page);
		model.addAttribute("beginIndex", begin);
		model.addAttribute("endIndex", end);
		model.addAttribute("currentIndex", currentPage);
		model.addAttribute("tourListByPageSize", page.getContent());
		return "tours";
	}
	
	
	@GetMapping("/{tourId}/tour-info")
	public String showTourInfo(@PathVariable("tourId") int tourId , Model model) throws IOException {
		
		Tour tour = tourService.findTourById(tourId);
	
		model.addAttribute("tour", tour);
		model.addAttribute("imgTour", CustomFileUtils.getImage("tour_" + tourId, tour.getImagePath()));

		return "tour-info";
	}

}