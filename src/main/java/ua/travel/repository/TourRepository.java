package ua.travel.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ua.travel.entity.Tour;

@Repository
public interface TourRepository extends JpaRepository<Tour, Integer> {

}
