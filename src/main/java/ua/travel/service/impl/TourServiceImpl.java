package ua.travel.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import ua.travel.entity.Tour;
import ua.travel.repository.TourRepository;
import ua.travel.service.TourService;

@Service
public class TourServiceImpl implements TourService {

	@Autowired private TourRepository tourRepository;
	
	@Override
	public void saveTour(Tour tour) {
		tourRepository.save(tour);
	}

	@Override
	public List<Tour> findAllTours() {
		return tourRepository.findAll();
	}

	@Override
	public Page<Tour> getPagebleTour(int pageNumber, int pageSize, String sort, String sortByField) {
		PageRequest request = new PageRequest(pageNumber - 1, pageSize, Sort.Direction.ASC, "id");
		return tourRepository.findAll(request);
	}
	
	

}
