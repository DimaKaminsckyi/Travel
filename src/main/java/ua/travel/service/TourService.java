package ua.travel.service;

import java.util.List;

import org.springframework.data.domain.Page;

import ua.travel.entity.Tour;

public interface TourService {
	
	void saveTour(Tour tour);
	
	Tour findTourById(int id);
	
	List<Tour> findAllTours();
	
	Page<Tour> getPagebleTour(int pageNumber,
							int pageSize,
							String sort,
							String sortByField);

}
