//package com.cts.controller;
//
//import java.util.List;
//import java.util.Optional;
//import java.util.Set;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.security.access.prepost.PreAuthorize;
//import org.springframework.web.bind.annotation.*;
//
//import com.cts.model.Booking;
//import com.cts.model.User;
//import com.cts.service.UserService;
//
//
//@RestController
//@RequestMapping("/user")
////@CrossOrigin(origins = "*")
//public class UserController {
//
//    @Autowired
//    private UserService service;
//
//    @GetMapping("/show")
//    public List<User> show() {
//        return service.show();
//    }
//
//    @GetMapping("/readone/{id}")
//    public Optional<User> showone(@PathVariable long id) {
//        return service.showone(id);
//    }
//
//    @PostMapping("/add")
//    public ResponseEntity<String> add(@RequestBody User user) {
//        service.add(user);
//        return new ResponseEntity<>("User is Created Successfully", HttpStatus.OK);
//    }
//
//    @PutMapping("/update/{id}")
//    public void update(@RequestBody User u, @PathVariable long id) {
//        service.update(u, id);
//    }
//
//    @DeleteMapping("/delete/{id}")
//    public ResponseEntity<String> delete(@PathVariable long id) {
//        service.delete(id);
//        return new ResponseEntity<>("User is deleted", HttpStatus.OK);
//    }
//
//    @GetMapping("/{id}")
//    public ResponseEntity<User> getUserProfile(@PathVariable Long id) {
//        return ResponseEntity.ok(service.getUserProfile(id));
//    }
//
//    @GetMapping("/{id}/booking")
//    public ResponseEntity<Set<Booking>> getUserBookings(@PathVariable Long id) {
//        Set<Booking> bookings = service.getUserBookings(id);
//        if (bookings != null) {
//            return ResponseEntity.ok(bookings);
//        }
//        return ResponseEntity.notFound().build();
//    }
//}



// ----------------------------------------------------------------------------------------------

//
//package com.cts.controller;
//
//import java.util.List;
//import java.util.Optional;
//import java.util.Set;
//import java.util.stream.Collectors;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PutMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.cts.dto.UserValidation;
//import com.cts.model.Booking;
//import com.cts.service.UserService;
//
//import jakarta.validation.Valid;
//
//@RestController
//@RequestMapping("/user")
//public class UserController {
//
//    @Autowired
//    private UserService service;
//
//    @GetMapping("/show")
//    public List<UserValidation> show() {
//        return service.show().stream().map(service::convertToUserValidation).collect(Collectors.toList());
//    }
//
//    @GetMapping("/readone/{id}")
//    public ResponseEntity<UserValidation> showone(@PathVariable long id) {
//        Optional<UserValidation> userDTO = service.showone(id);
//        return userDTO.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
//    }
//
//    @PostMapping("/add")
//    public ResponseEntity<String> add(@RequestBody @Valid UserValidation userDTO) {
//        service.add(service.convertToUser(userDTO));
//        return new ResponseEntity<>("User is Created Successfully", HttpStatus.OK);
//    }
//
//    @PutMapping("/update/{id}")
//    public ResponseEntity<String> update(@RequestBody @Valid UserValidation userDTO, @PathVariable long id) {
//        service.update(service.convertToUser(userDTO), id);
//        return new ResponseEntity<>("User is Updated Successfully", HttpStatus.OK);
//    }
//
//    @DeleteMapping("/delete/{id}")
//    public ResponseEntity<String> delete(@PathVariable long id) {
//        service.delete(id);
//        return new ResponseEntity<>("User is deleted", HttpStatus.OK);
//    }
//
//    @GetMapping("/{id}")
//    public ResponseEntity<UserValidation> getUserProfile(@PathVariable Long id) {
//        UserValidation userDTO = service.convertToUserValidation(service.getUserProfile(id));
//        return ResponseEntity.ok(userDTO);
//    }
//
//    @GetMapping("/{id}/booking")
//    public ResponseEntity<Set<Booking>> getUserBookings(@PathVariable Long id) {
//        Set<Booking> bookings = service.getUserBookings(id);
//        if (bookings != null) {
//            return ResponseEntity.ok(bookings);
//        }
//        return ResponseEntity.notFound().build();
//    }
//}





package com.cts.controller;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

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
import org.springframework.web.bind.annotation.RestController;

import com.cts.dto.UserValidation;
import com.cts.model.Booking;
import com.cts.service.UserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService service;

    @GetMapping("/show")
    public List<UserValidation> show() {
        return service.show().stream().map(service::convertToUserValidation).collect(Collectors.toList());
    }

    @GetMapping("/readone/{id}")
    public ResponseEntity<UserValidation> showone(@PathVariable long id) {
        Optional<UserValidation> userValidation = service.showone(id);
        return userValidation.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/add")
    public ResponseEntity<String> add(@RequestBody @Valid UserValidation userValidation) {
        service.add(service.convertToUser(userValidation));
        return new ResponseEntity<>("User is Created Successfully", HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<String> update(@RequestBody @Valid UserValidation userValidation, @PathVariable long id) {
        service.update(service.convertToUser(userValidation), id);
        return new ResponseEntity<>("User is Updated Successfully", HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable long id) {
        service.delete(id);
        return new ResponseEntity<>("User is deleted", HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserValidation> getUserProfile(@PathVariable Long id) {
        UserValidation userValidation = service.convertToUserValidation(service.getUserProfile(id));
        return ResponseEntity.ok(userValidation);
    }

    @GetMapping("/{id}/booking")
    public ResponseEntity<Set<Booking>> getUserBookings(@PathVariable Long id) {
        Set<Booking> bookings = service.getUserBookings(id);
        if (bookings != null) {
            return ResponseEntity.ok(bookings);
        }
        return ResponseEntity.notFound().build();
    }
}
