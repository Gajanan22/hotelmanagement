//package com.cts.controller;
//
//
//import java.util.List;
//import java.util.Optional;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import com.cts.model.Booking;
//import com.cts.service.BookingService;
//
//import jakarta.validation.Valid;
//
//@RestController
//@RequestMapping("/booking")
////@CrossOrigin(origins = "*")
//public class BookingController {
//
//    @Autowired
//    private BookingService bookingService;
//
//    @GetMapping("/show")
//    public ResponseEntity<List<Booking>> show() {
//        List<Booking> bookings = bookingService.findAll();
//        return ResponseEntity.ok(bookings);
//    }
//
//    @GetMapping("/readone/{id}")
//    public ResponseEntity<Booking> showone(@PathVariable Long id) {
//        Optional<Booking> booking = bookingService.findById(id);
//        return booking.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
//    }
//
//    @PostMapping("/add/{uid}/{hid}")
//    public ResponseEntity<Booking> add(@Valid @RequestBody Booking booking, @PathVariable long uid, @PathVariable long hid) {
//        return ResponseEntity.ok(bookingService.addBooking(booking, uid, hid));
//    }
//
//    @PutMapping("/update/{id}")
//    public ResponseEntity<Booking> update(@RequestBody Booking newBooking, @PathVariable Long id) {
//        Optional<Booking> updatedBooking = bookingService.update(newBooking, id);
//        return updatedBooking.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
//    }
//
//    @DeleteMapping("/delete/{id}")
//    public ResponseEntity<Void> delete(@PathVariable Long id) {
//        if (bookingService.existsById(id)) {
//            bookingService.deleteById(id);
//            return ResponseEntity.noContent().build();
//        }
//        return ResponseEntity.notFound().build();
//    }
//
//    @GetMapping("/user/{userId}")
//    public ResponseEntity<List<Booking>> getBookingsByUserId(@PathVariable Long userId) {
//        List<Booking> bookings = bookingService.findByUserId(userId);
//        return ResponseEntity.ok(bookings);
//    }
//
//    @PostMapping
//    public ResponseEntity<Booking> createBooking(@RequestBody Booking booking) {
//        Booking savedBooking = bookingService.save(booking);
//        return ResponseEntity.ok(savedBooking);
//    }
//}


//package com.cts.controller;
//
//import java.util.List;
//import java.util.Optional;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import com.cts.dto.BookingValidation;
//import com.cts.model.Booking;
//import com.cts.service.BookingService;
//
//import jakarta.validation.Valid;
//
//@RestController
//@RequestMapping("/booking")
//public class BookingController {
//
//    @Autowired
//    private BookingService bookingService;
//
//    @GetMapping("/show")
//    public ResponseEntity<List<Booking>> show() {
//        List<Booking> bookings = bookingService.findAll();
//        return ResponseEntity.ok(bookings);
//    }
//
//    @GetMapping("/readone/{id}")
//    public ResponseEntity<Booking> showone(@PathVariable Long id) {
//        Optional<Booking> booking = bookingService.findById(id);
//        return booking.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
//    }
//
//    @PostMapping("/add/{uid}/{hid}")
//    public ResponseEntity<Booking> add(@Valid @RequestBody BookingValidation bookingValidation, @PathVariable long uid, @PathVariable long hid) {
//        Booking booking = new Booking();
//        booking.setRoom(bookingValidation.getRoom());
//        booking.setAdult(bookingValidation.getAdult());
//        booking.setChild(bookingValidation.getChild());
//        booking.setDeparture(bookingValidation.getDeparture());
//        booking.setArrival(bookingValidation.getArrival());
//        booking.setTotalamount(bookingValidation.getTotalamount());
//        booking.setSavings(bookingValidation.getSavings());
//        return ResponseEntity.ok(bookingService.addBooking(booking, uid, hid));
//    }
//
//    @PutMapping("/update/{id}")
//    public ResponseEntity<Booking> update(@Valid @RequestBody BookingValidation newBookingValidation, @PathVariable Long id) {
//        Booking newBooking = new Booking();
//        newBooking.setRoom(newBookingValidation.getRoom());
//        newBooking.setAdult(newBookingValidation.getAdult());
//        newBooking.setChild(newBookingValidation.getChild());
//        newBooking.setDeparture(newBookingValidation.getDeparture());
//        newBooking.setArrival(newBookingValidation.getArrival());
//        newBooking.setTotalamount(newBookingValidation.getTotalamount());
//        newBooking.setSavings(newBookingValidation.getSavings());
//        Optional<Booking> updatedBooking = bookingService.update(newBooking, id);
//        return updatedBooking.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
//    }
//
//    @DeleteMapping("/delete/{id}")
//    public ResponseEntity<Void> delete(@PathVariable Long id) {
//        if (bookingService.existsById(id)) {
//            bookingService.deleteById(id);
//            return ResponseEntity.noContent().build();
//        }
//        return ResponseEntity.notFound().build();
//    }
//
//    @GetMapping("/user/{userId}")
//    public ResponseEntity<List<Booking>> getBookingsByUserId(@PathVariable Long userId) {
//        List<Booking> bookings = bookingService.findByUserId(userId);
//        return ResponseEntity.ok(bookings);
//    }
//
//    @PostMapping
//    public ResponseEntity<Booking> createBooking(@Valid @RequestBody BookingValidation bookingValidation) {
//        Booking booking = new Booking();
//        booking.setRoom(bookingValidation.getRoom());
//        booking.setAdult(bookingValidation.getAdult());
//        booking.setChild(bookingValidation.getChild());
//        booking.setDeparture(bookingValidation.getDeparture());
//        booking.setArrival(bookingValidation.getArrival());
//        booking.setTotalamount(bookingValidation.getTotalamount());
//        booking.setSavings(bookingValidation.getSavings());
//        Booking savedBooking = bookingService.save(booking);
//        return ResponseEntity.ok(savedBooking);
//    }
//}

package com.cts.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.cts.dto.BookingValidation;
import com.cts.model.Booking;
import com.cts.service.BookingService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/booking")
public class BookingController {

    @Autowired
    private BookingService bookingService;

    @GetMapping("/show")
    public ResponseEntity<List<Booking>> show() {
        List<Booking> bookings = bookingService.findAll();
        return ResponseEntity.ok(bookings);
    }

    @GetMapping("/readone/{id}")
    public ResponseEntity<Booking> showone(@PathVariable Long id) {
        Optional<Booking> booking = bookingService.findById(id);
        return booking.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/add/{uid}/{hid}")
    public ResponseEntity<Booking> add(@Valid @RequestBody BookingValidation bookingValidation, @PathVariable long uid, @PathVariable long hid) {
        Booking booking = bookingService.addBooking(bookingValidation, uid, hid);
        return ResponseEntity.ok(booking);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Booking> update(@Valid @RequestBody BookingValidation newBookingValidation, @PathVariable Long id) {
        Optional<Booking> updatedBooking = bookingService.update(newBookingValidation, id);
        return updatedBooking.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (bookingService.existsById(id)) {
            bookingService.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Booking>> getBookingsByUserId(@PathVariable Long userId) {
        List<Booking> bookings = bookingService.findByUserId(userId);
        return ResponseEntity.ok(bookings);
    }

    @PostMapping
    public ResponseEntity<Booking> createBooking(@Valid @RequestBody Booking bookingValidation) {
        Booking booking = bookingService.save(bookingValidation);
        return ResponseEntity.ok(booking);
    }
}
