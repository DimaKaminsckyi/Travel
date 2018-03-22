package ua.travel.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name = "hotel")
public class Hotel extends BaseEntity {

    @Column(name = "title")
    private String title;

    @ManyToOne
    @JoinColumn(name = "id_country")
    private Country country;

    @OneToOne(mappedBy = "hotel")
    private Tour tour;

    @OneToOne
    @JoinColumn(name = "hotel_details_id")
    private HotelDetails hotelDetails;

    public Hotel() {
    }

    public Hotel(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }


    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public HotelDetails getHotelDetails() {
        return hotelDetails;
    }

    public void setHotelDetails(HotelDetails hotelDetails) {
        this.hotelDetails = hotelDetails;
    }

    public Tour getTour() {
        return tour;
    }

    public void setTour(Tour tour) {
        this.tour = tour;
    }
}
