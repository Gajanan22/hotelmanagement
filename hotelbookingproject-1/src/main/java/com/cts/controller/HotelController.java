//package com.cts.controller;
//
//import java.util.List;
//import java.util.Optional;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//
//import com.cts.model.Hotel;
//import com.cts.service.HotelService;
//
//
//
//@RestController
//@RequestMapping("/hotel")
////@CrossOrigin(origins = "*")
//public class HotelController {
//
//    @Autowired
//    private HotelService service;
//
//    @GetMapping("/show")
//    public List<Hotel> show(@RequestParam(required = false) String place) {
//        if (place != null && !place.isEmpty()) {
//            return service.findByPlace(place);
//        }
//        return service.show();
//    }
//
//    @GetMapping("/readone/{id}")
//    public Optional<Hotel> showone(@PathVariable long id) {
//        return service.findById(id);
//    }
//
//    @PostMapping("/add")
//    public void add(@RequestBody Hotel hotel) {
//        service.save(hotel);
//    }
//
//    @PutMapping("/update/{id}")
//    public void update(@RequestBody Hotel h, @PathVariable long id) {
//        service.update(h, id);
//    }
//
//    @DeleteMapping("/delete/{id}")
//    public void delete(@PathVariable long id) {
//        service.deleteById(id);
//    }
//}




package com.cts.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cts.dto.HotelValidation;
import com.cts.service.HotelService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/hotel")
public class HotelController {

    @Autowired
    private HotelService service;

    @GetMapping("/show")
    public List<HotelValidation> show(@RequestParam(required = false) String place) {
        if (place != null && !place.isEmpty()) {
            return service.findByPlace(place);
        }
        return service.show();
    }

    @GetMapping("/readone/{id}")
    public ResponseEntity<HotelValidation> showone(@PathVariable long id) {
        Optional<HotelValidation> hotelValidation = service.findById(id);
        return hotelValidation.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/add")
    public ResponseEntity<String> add(@RequestBody @Valid HotelValidation hotelValidation) {
        service.save(hotelValidation);
        return new ResponseEntity<>("Hotel is Created Successfully", HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<String> update(@RequestBody @Valid HotelValidation hotelValidation, @PathVariable long id) {
        service.update(hotelValidation, id);
        return new ResponseEntity<>("Hotel is Updated Successfully", HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable long id) {
        service.deleteById(id);
        return new ResponseEntity<>("Hotel is deleted", HttpStatus.OK);
    }
}