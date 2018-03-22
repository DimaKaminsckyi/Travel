package ua.travel.entity;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "tour")
public class Tour extends BaseEntity {

    @Column(name = "title")
    private String title;
    
    @Column(name = "description")
    private String description;

    @Column(name = "price")
    private BigDecimal price;
    
    @OneToOne
    @JoinColumn(name = "tour_details_id")
    private TourDetails tourDetails;

    @OneToOne
    @JoinColumn(name = "hotel_id")
    private Hotel hotel;


    @ManyToOne
    @JoinColumn(name = "id_country")
    private Country country;

    public Tour() {
    }

    public Tour(String title, String description, BigDecimal price) {
        this.title = title;
        this.description = description;
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }


    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
    
    
}
