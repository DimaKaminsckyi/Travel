package ua.travel.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import ua.travel.domain.CreateTourRequest;
import ua.travel.entity.Tour;
import ua.travel.mapper.TourMapper;
import ua.travel.service.TourService;
import ua.travel.service.utils.CustomFileUtils;

@Controller
public class TourAddController {

	@Autowired TourService tourService;
	
	@GetMapping("/add-tour")
	public String createAdvertisement( 
			Model model) {
		CreateTourRequest tourRequest = new CreateTourRequest();
		
		model.addAttribute("title", "Create Advertisement");
		model.addAttribute("tourModel", tourRequest);
		
		return "admin/add-tour";
	}
	
	@PostMapping("/add-tour")
	public String createAdvertisementForm(
			@ModelAttribute("tourModel") CreateTourRequest request
			) throws IOException {
		Tour tour = TourMapper.TourRequest(request);
		
		
		tourService.saveTour(tour);
		
		CustomFileUtils.createFolder("tour_" + tour.getId());
		CustomFileUtils.createImage("tour_" + tour.getId(), request.getTourImage());

		return "redirect:/";
	}
	
}
