package ua.travel.domain;


import java.math.BigDecimal;

import org.springframework.web.multipart.MultipartFile;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter @Setter
public class CreateTourRequest {
		private String title;
		private String description;
		private BigDecimal price;
		private String grubby;
		private String departureFromTheCity;
		private int dayInTour;
		private String hotelTitle;
		private int numberOfRooms;
		private int category;
		private String aboutHotel;
		private String countryName;
		private MultipartFile tourImage;
	}
