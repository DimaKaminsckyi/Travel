package ua.travel.controller;

import java.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import ua.travel.domain.EditTourRequest;
import ua.travel.entity.Tour;
import ua.travel.mapper.TourMapper;
import ua.travel.service.TourService;
import ua.travel.service.utils.CustomFileUtils;

@Controller
@SessionAttributes("editModel")
public class TourController {
	
	@Autowired private TourService tourService;
	
	@GetMapping("/tours/{pageNumber}")
	public String showTours(@PathVariable("pageNumber") int pageNumber,
			
			@RequestParam(value = "field", required = false) String field,
			@RequestParam(value = "sort", required = false) String sort,
			@RequestParam(value = "total", required = false) String total,
			
			Model model) throws IOException {
		
		
		int totalPerPage = total != null ? Integer.valueOf(total) : 6;
		String sortDirection = sort != null ? sort.toUpperCase() : "ASC";
		String sortByField = field != null ? field : "id";
		
		Page<Tour> page = tourService.getPagebleTour(pageNumber, totalPerPage, sortDirection, sortByField);
		
		
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
		
		
		model.addAttribute("sortByField", sortByField);
	    model.addAttribute("sortDirection", sortDirection);
	    model.addAttribute("totalPerPage", totalPerPage);
		
		return "tours";
	}
	
	
	@GetMapping("/{tourId}/tour-info")
	public String showTourInfo(@PathVariable("tourId") int tourId , Model model) throws IOException {
		
		Tour tour = tourService.findTourById(tourId);
	
		model.addAttribute("tour", tour);
		model.addAttribute("imgTour", CustomFileUtils.getImage("tour_" + tourId, tour.getImagePath()));

		return "tour-info";
	}
	
	
	
	@GetMapping("/edit-tour/{tourId}")
	public String editTour(
			@PathVariable("tourId") int tourId,
			Model model) {
		Tour tour = tourService.findTourById(tourId);
		
		EditTourRequest request = TourMapper.entityToEditTour(tour);
		model.addAttribute("editModel", request);
		return "admin/edit-tour";
	}
	
	@PostMapping("/edit-tour/{tourId}")
	public String saveEditedTour(
			@ModelAttribute("editModel") EditTourRequest request,
			@PathVariable("tourId") int tourId
			) throws IOException {
		
		
		
		Tour entity = TourMapper.editRequestToEntity(request);
		
		
		tourService.editUser(entity);		
		CustomFileUtils.createFolder("tour_" + entity.getId());
		CustomFileUtils.createImage("tour_" + entity.getId(), request.getTourImage());
		
		return "redirect:/{tourId}/tour-info";
	}
	
	@GetMapping("/delete-tour/{tourId}")
	public String TourrDeletePage(Model model, @PathVariable("tourId") int tourId) {
		
		
		
		Tour tour = tourService.findTourById(tourId);
		EditTourRequest request =  TourMapper.entityToEditTour(tour);
		tourService.deleteTour(tourId);
		
//		String filename = "
//		File file = new File(filename);
//		file.delete();
		
		model.addAttribute("tour", request);		
		return "redirect:/tours/1";
	}

}