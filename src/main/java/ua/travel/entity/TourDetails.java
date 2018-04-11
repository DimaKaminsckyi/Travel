package ua.travel.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "tour_details")
@Getter @Setter
public class TourDetails extends BaseEntity {
	
	@Column(name = "grubby")
	private String grubby;
	
	@Column(name = "departure_from_the_city")
	private String departureFromTheCity;
	
	@Column(name = "day_in_tour")
	private int dayInTour;
	
	 @OneToOne(mappedBy = "tourDetails", cascade = CascadeType.ALL)
	    private Tour tour;

	 public TourDetails() {
		 
	 }
	 
	public TourDetails(String grubby, String departureFromTheCity, int dayInTour) {
		super();
		this.grubby = grubby;
		this.departureFromTheCity = departureFromTheCity;
		this.dayInTour = dayInTour;
	}

	 
	 
}
