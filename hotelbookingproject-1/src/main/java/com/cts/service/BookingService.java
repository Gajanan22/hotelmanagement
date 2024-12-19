package com.cts.service;
//
//import java.util.List;
//import java.util.Optional;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import com.cts.dto.UserValidation;
//import com.cts.exception.ResourceNotFoundException;
//import com.cts.model.Booking;
//import com.cts.model.Hotel;
//import com.cts.model.User;
//import com.cts.repository.BookingRepository;
//
//@Service
//public class BookingService {
//
//    @Autowired
//    private BookingRepository bookingRepo;
//
//    @Autowired
//    private UserService userService;
//
//    @Autowired
//    private HotelService hotelService;
//
//    public List<Booking> findAll() {
//        return bookingRepo.findAll();
//    }
//
//    public Optional<Booking> findById(Long id) {
//        return bookingRepo.findById(id);
//    }
//
//    public Booking save(Booking booking) {
//        return bookingRepo.save(booking);
//    }
//
//    public Optional<Booking> update(Booking newBooking, Long id) {
//        return Optional.ofNullable(bookingRepo.findById(id).map(existingBooking -> {
//            existingBooking.setRoom(newBooking.getRoom());
//            existingBooking.setAdult(newBooking.getAdult());
//            existingBooking.setChild(newBooking.getChild());
//            existingBooking.setDeparture(newBooking.getDeparture());
//            existingBooking.setArrival(newBooking.getArrival());
//            existingBooking.setTotalamount(newBooking.getTotalamount());
//            existingBooking.setSavings(newBooking.getSavings());
//            return bookingRepo.save(existingBooking);
//        }).orElseThrow(() -> new ResourceNotFoundException("Booking not found with id " + id)));
//    }
//
//    public void deleteById(Long id) {
//        if (!bookingRepo.existsById(id)) {
//            throw new ResourceNotFoundException("Booking not found with id " + id);
//        }
//        bookingRepo.deleteById(id);
//    }
//
//    public boolean existsById(Long id) {
//        return bookingRepo.existsById(id);
//    }
//
//    public List<Booking> findByUserId(Long userId) {
//        return bookingRepo.findByUserId(userId);
//    }
//
//    public Booking addBooking(Booking booking, long uid, long hid) {
//        UserValidation user = userService.showone(uid).orElseThrow(() -> new ResourceNotFoundException("User not found with id " + uid));
//        Hotel hotel = hotelService.findById(hid).orElseThrow(() -> new ResourceNotFoundException("Hotel not found with id " + hid));
//        booking.setUser(user);
//        booking.setHotel(hotel);
//        return bookingRepo.save(booking);
//    }
//}

//import java.util.List;
//import java.util.Optional;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import com.cts.exception.ResourceNotFoundException;
//import com.cts.model.Booking;
//import com.cts.model.Hotel;
//import com.cts.model.User;
//import com.cts.repository.BookingRepository;
//
//@Service
//public class BookingService {
//
//    @Autowired
//    private BookingRepository bookingRepo;
//
//    @Autowired
//    private UserService userService;
//
//    @Autowired
//    private HotelService hotelService;
//
//    public List<Booking> findAll() {
//        return bookingRepo.findAll();
//    }
//
//    public Optional<Booking> findById(Long id) {
//        return bookingRepo.findById(id);
//    }
//
//    public Booking save(Booking booking) {
//        return bookingRepo.save(booking);
//    }
//
//    public Optional<Booking> update(Booking newBooking, Long id) {
//        return Optional.ofNullable(bookingRepo.findById(id).map(existingBooking -> {
//            existingBooking.setRoom(newBooking.getRoom());
//            existingBooking.setAdult(newBooking.getAdult());
//            existingBooking.setChild(newBooking.getChild());
//            existingBooking.setDeparture(newBooking.getDeparture());
//            existingBooking.setArrival(newBooking.getArrival());
//            existingBooking.setTotalamount(newBooking.getTotalamount());
//            existingBooking.setSavings(newBooking.getSavings());
//            return bookingRepo.save(existingBooking);
//        }).orElseThrow(() -> new ResourceNotFoundException("Booking not found with id " + id)));
//    }
//
//    public void deleteById(Long id) {
//        if (!bookingRepo.existsById(id)) {
//            throw new ResourceNotFoundException("Booking not found with id " + id);
//        }
//        bookingRepo.deleteById(id);
//    }
//
//    public boolean existsById(Long id) {
//        return bookingRepo.existsById(id);
//    }
//
//    public List<Booking> findByUserId(Long userId) {
//        return bookingRepo.findByUserId(userId);
//    }
//
//    public Booking addBooking(Booking booking, long uid, long hid) {
//        User user = userService.showone(uid).map(userService::convertToUser).orElseThrow(() -> new ResourceNotFoundException("User not found with id " + uid));
//        Hotel hotel = hotelService.findById(hid).map(hotelService::convertToHotel).orElseThrow(() -> new ResourceNotFoundException("Hotel not found with id " + hid));
//        booking.setUser(user);
//        booking.setHotel(hotel);
//        return bookingRepo.save(booking);
//    }
//}

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.dto.BookingValidation;
import com.cts.dto.HotelValidation;
import com.cts.exception.ResourceNotFoundException;
import com.cts.model.Booking;
import com.cts.model.Hotel;
import com.cts.model.User;
import com.cts.repository.BookingRepository;

@Service
public class BookingService {

    @Autowired
    private BookingRepository bookingRepo;

    @Autowired
    private UserService userService;

    @Autowired
    private HotelService hotelService;

    public List<Booking> findAll() {
        return bookingRepo.findAll();
    }

    public Optional<Booking> findById(Long id) {
        return bookingRepo.findById(id);
    }

    public Booking save(Booking booking) {
        return bookingRepo.save(booking);
    }

    public Optional<Booking> update(BookingValidation newBookingValidation, Long id) {
        return Optional.ofNullable(bookingRepo.findById(id).map(existingBooking -> {
            existingBooking.setRoom(newBookingValidation.getRoom());
            existingBooking.setAdult(newBookingValidation.getAdult());
            existingBooking.setChild(newBookingValidation.getChild());
            existingBooking.setDeparture(newBookingValidation.getDeparture());
            existingBooking.setArrival(newBookingValidation.getArrival());
            existingBooking.setTotalamount(newBookingValidation.getTotalamount());
            existingBooking.setSavings(newBookingValidation.getSavings());
            return bookingRepo.save(existingBooking);
        }).orElseThrow(() -> new ResourceNotFoundException("Booking not found with id " + id)));
    }

    public void deleteById(Long id) {
        if (!bookingRepo.existsById(id)) {
            throw new ResourceNotFoundException("Booking not found with id " + id);
        }
        bookingRepo.deleteById(id);
    }

    public boolean existsById(Long id) {
        return bookingRepo.existsById(id);
    }

    public List<Booking> findByUserId(Long userId) {
        return bookingRepo.findByUserId(userId);
    }

    public Booking addBooking(BookingValidation bookingValidation, long uid, long hid) {
        User user = userService.showone(uid).map(userService::convertToUser).orElseThrow(() -> new ResourceNotFoundException("User not found with id " + uid));
        HotelValidation hotel = hotelService.findById(hid).orElseThrow(() -> new ResourceNotFoundException("Hotel not found with id " + hid));

        Booking booking = new Booking();
        booking.setRoom(bookingValidation.getRoom());
        booking.setAdult(bookingValidation.getAdult());
        booking.setChild(bookingValidation.getChild());
        booking.setDeparture(bookingValidation.getDeparture());
        booking.setArrival(bookingValidation.getArrival());
        booking.setTotalamount(bookingValidation.getTotalamount());
        booking.setSavings(bookingValidation.getSavings());
        booking.setUser(user);
        booking.setHotel(convertToHotel(hotel));

        return bookingRepo.save(booking);
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
}
