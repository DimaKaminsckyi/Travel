package ua.travel.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "hotel_details")
public class HotelDetails extends BaseEntity {

    @Column(name = "number_of_rooms")
    private int numberOfRooms;

    @Column(name = "category")
    private int category;

    @OneToOne(mappedBy = "hotelDetails")
    private Hotel hotel;

    public HotelDetails() {
    }

    public HotelDetails(int numberOfRooms, int category) {
        this.numberOfRooms = numberOfRooms;
        this.category = category;
    }

    public int getNumberOfRooms() {
        return numberOfRooms;
    }

    public void setNumberOfRooms(int numberOfRooms) {
        this.numberOfRooms = numberOfRooms;
    }

    public int getCategory() {
        return category;
    }

    public void setCategory(int category) {
        this.category = category;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }
}