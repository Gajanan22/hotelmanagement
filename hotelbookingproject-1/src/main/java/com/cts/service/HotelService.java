package com.cts.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.dto.HotelValidation;
import com.cts.exception.ResourceNotFoundException;
import com.cts.model.Hotel;
import com.cts.repository.HotelRepository;

@Service
public class HotelService {

    @Autowired
    private HotelRepository hotelRepo;

    public List<HotelValidation> show() {
        return hotelRepo.findAll().stream().map(this::convertToHotelValidation).collect(Collectors.toList());
    }

    public List<HotelValidation> findByPlace(String place) {
        return hotelRepo.findByPlace(place).stream().map(this::convertToHotelValidation).collect(Collectors.toList());
    }

    public Optional<HotelValidation> findById(long id) {
        return hotelRepo.findById(id).map(this::convertToHotelValidation);
    }

    public void save(HotelValidation hotelValidation) {
        hotelRepo.save(convertToHotel(hotelValidation));
    }

    public void update(HotelValidation hotelValidation, long id) {
        Hotel hotel = hotelRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Hotel not found with id " + id));
        hotel.setRating(hotelValidation.getRating());
        hotel.setRatingtext(hotelValidation.getRatingtext());
        hotel.setName(hotelValidation.getName());
        hotel.setPlace(hotelValidation.getPlace());
        hotel.setPrice(hotelValidation.getPrice());
        hotelRepo.save(hotel);
    }

    public void deleteById(long id) {
        if (!hotelRepo.existsById(id)) {
            throw new ResourceNotFoundException("Hotel not found with id " + id);
        }
        hotelRepo.deleteById(id);
    }

    public Hotel convertToHotel(HotelValidation hotelValidation) {
        Hotel hotel = new Hotel();
        hotel.setRating(hotelValidation.getRating());
        hotel.setRatingtext(hotelValidation.getRatingtext());
        hotel.setName(hotelValidation.getName());
        hotel.setPlace(hotelValidation.getPlace());
        hotel.setPrice(hotelValidation.getPrice());
        return hotel;
    }

    private HotelValidation convertToHotelValidation(Hotel hotel) {
        return new HotelValidation(
            hotel.getName(),
            hotel.getPlace(),
            hotel.getPrice(),
            hotel.getRating(),
            hotel.getRatingtext()
        );
    }
}
