//package com.cts.service;
//
//
//
//import java.util.List;
//import java.util.Optional;
//import java.util.Set;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.stereotype.Service;
//
//import com.cts.exception.ResourceNotFoundException;
//import com.cts.model.Booking;
//import com.cts.model.User;
//import com.cts.repository.UserRepository;
//
//
//@Service
//public class UserService {
//
//    @Autowired
//    private UserRepository ur;
//
//    @Autowired
//    private PasswordEncoder passwordEncoder;
//
//    public List<User> show() {
//        return ur.findAll();
//    }
//
//    public Optional<User> showone(long id) {
//        return ur.findById(id);
//    }
//
//    public void add(User user) {
//        user.setPassword(passwordEncoder.encode(user.getPassword()));
//        ur.save(user);
//    }
//
//    public void update(User u, long id) {
//        User user = ur.findById(id).orElseThrow(() -> new ResourceNotFoundException("User not found with id " + id));
//        user.setNumber(u.getNumber());
//        user.setUsername(u.getUsername());
//        user.setPassword(passwordEncoder.encode(u.getPassword()));
//        user.setEmail(u.getEmail());
//        user.setDob(u.getDob());
//        user.setGender(u.getGender());
//        ur.save(user);
//    }
//
//    public void delete(long id) {
//        if (!ur.existsById(id)) {
//            throw new ResourceNotFoundException("User not found with id " + id);
//        }
//        ur.deleteById(id);
//    }
//
//    public Set<Booking> getUserBookings(Long id) {
//        User user = ur.findById(id).orElseThrow(() -> new ResourceNotFoundException("User not found with id " + id));
//        return user.getBookings();
//    }
//
//    public User getUserProfile(Long id) {
//        return ur.findById(id).orElseThrow(() -> new ResourceNotFoundException("User not found with id " + id));
//    }
//}


package com.cts.service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.cts.dto.UserValidation;
import com.cts.exception.ResourceNotFoundException;
import com.cts.model.Booking;
import com.cts.model.User;
import com.cts.repository.UserRepository;

@Service
public class UserService {
    
    @Autowired
    private UserRepository ur;
    
    @Autowired
    private PasswordEncoder passwordEncoder;
    
    public List<User> show() {
        return ur.findAll();
    }

    public Optional<UserValidation> showone(long id) {
        return ur.findById(id).map(this::convertToUserValidation);
    }

    public void add(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        ur.save(user);
    }

    public void update(User u, long id) {
        User user = ur.findById(id).orElseThrow(() -> new ResourceNotFoundException("User not found with id " + id));
        user.setNumber(u.getNumber());
        user.setUsername(u.getUsername());
        user.setPassword(passwordEncoder.encode(u.getPassword()));
        user.setEmail(u.getEmail());
        user.setDob(u.getDob());
        user.setGender(u.getGender());
        ur.save(user);
    }

    public void delete(long id) {
        if (!ur.existsById(id)) {
            throw new ResourceNotFoundException("User not found with id " + id);
        }
        ur.deleteById(id);
    }

    public Set<Booking> getUserBookings(Long id) {
        User user = ur.findById(id).orElseThrow(() -> new ResourceNotFoundException("User not found with id " + id));
        return user.getBookings();
    }

    public User getUserProfile(Long id) {
        return ur.findById(id).orElseThrow(() -> new ResourceNotFoundException("User not found with id " + id));
    }

    // Add these conversion methods
    public User convertToUser(UserValidation userValidation) {
        User user = new User();
        
        user.setUsername(userValidation.getUsername());
        user.setPassword(passwordEncoder.encode(userValidation.getPassword()));  // Encrypt the password
        user.setEmail(userValidation.getEmail());
        user.setDob(userValidation.getDob());
        user.setGender(userValidation.getGender());
        user.setNumber(userValidation.getNumber());
        // Set other fields as necessary
        return user;
    }

    public UserValidation convertToUserValidation(User user) {
        return new UserValidation(
            user.getUsername(),
            user.getPassword(),
            user.getEmail(),
            user.getDob(),
            user.getGender(),
            user.getNumber(),
            user.getRoles()
        );
    }
}
