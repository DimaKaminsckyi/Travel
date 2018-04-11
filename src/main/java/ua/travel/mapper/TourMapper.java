package ua.travel.mapper;

import ua.travel.domain.CreateTourRequest;
import ua.travel.domain.EditTourRequest;
import ua.travel.entity.Country;
import ua.travel.entity.Hotel;
import ua.travel.entity.HotelDetails;
import ua.travel.entity.Tour;
import ua.travel.entity.TourDetails;

public interface TourMapper {
	
	public static Tour TourRequest(CreateTourRequest tourRequest) {
		Tour tour = new Tour();
		tour.setTitle(tourRequest.getTitle());
		tour.setDescription(tourRequest.getDescription());
		tour.setPrice(tourRequest.getPrice());
		tour.setImagePath(tourRequest.getTourImage().getOriginalFilename());
		
		TourDetails tourDetails = new TourDetails();
		tourDetails.setDepartureFromTheCity(tourRequest.getDepartureFromTheCity());
		tourDetails.setDayInTour(tourRequest.getDayInTour());
		tourDetails.setGrubby(tourRequest.getGrubby());
		tour.setTourDetails(tourDetails);
		
		Hotel hotel = new Hotel();
		hotel.setTitle(tourRequest.getHotelTitle());
		tour.setHotel(hotel);
		
		HotelDetails hotelDetails = new HotelDetails();
		hotelDetails.setAboutHotel(tourRequest.getAboutHotel());
		hotelDetails.setCategory(tourRequest.getCategory());
		hotelDetails.setNumberOfRooms(tourRequest.getNumberOfRooms());
		tour.getHotel().setHotelDetails(hotelDetails);
		
		Country country = new Country();
		country.setName(tourRequest.getCountryName());
		tour.setCountry(country);
		
		
		return tour;
	}
	
	
	
	public static EditTourRequest entityToEditTour(Tour tour) {
		EditTourRequest request = new EditTourRequest();
		request.setId(tour.getId());
		request.setGrubby(tour.getTourDetails().getGrubby());
		request.setAboutHotel(tour.getHotel().getHotelDetails().getAboutHotel());
		request.setCategory(tour.getHotel().getHotelDetails().getCategory());
		request.setCountryName(tour.getCountry().getName());
		request.setDayInTour(tour.getTourDetails().getDayInTour());
		request.setDepartureFromTheCity(tour.getTourDetails().getDepartureFromTheCity());
		request.setDescription(tour.getDescription());
		request.setHotelTitle(tour.getHotel().getTitle());
		request.setNumberOfRooms(tour.getHotel().getHotelDetails().getNumberOfRooms());
		request.setPrice(tour.getPrice());
		request.setTitle(tour.getTitle());
		return request;
	}
	
	public static Tour editRequestToEntity(EditTourRequest request) {
		Tour tour = new Tour();
		tour.setTitle(request.getTitle());
		tour.setDescription(request.getDescription());
		tour.setPrice(request.getPrice());
		tour.setImagePath(request.getTourImage().getOriginalFilename());
		
		TourDetails tourDetails = new TourDetails();
		tourDetails.setDepartureFromTheCity(request.getDepartureFromTheCity());
		tourDetails.setDayInTour(request.getDayInTour());
		tourDetails.setGrubby(request.getGrubby());
		tour.setTourDetails(tourDetails);
		
		Hotel hotel = new Hotel();
		hotel.setTitle(request.getHotelTitle());
		tour.setHotel(hotel);
		
		HotelDetails hotelDetails = new HotelDetails();
		hotelDetails.setAboutHotel(request.getAboutHotel());
		hotelDetails.setCategory(request.getCategory());
		hotelDetails.setNumberOfRooms(request.getNumberOfRooms());
		tour.getHotel().setHotelDetails(hotelDetails);
		
		Country country = new Country();
		country.setName(request.getCountryName());
		tour.setCountry(country);
		
		
		return tour;
	}

}
