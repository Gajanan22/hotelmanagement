//package com.cts.config;
//
//import java.util.Arrays;
//import java.util.Collection;
//import java.util.List;
//import java.util.Optional;
//import java.util.stream.Collectors;
// 
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Component;
// 
//import com.cts.model.User;
//import com.cts.repository.UserRepository;
// 
//@Component
//public class UserUserDetailsService implements UserDetailsService {
// 
//	@Autowired
//	private UserRepository userRepository;
// 
//	@Override
//	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//		// TODO Auto-generated method stub
//		Optional<User> user=userRepository.findByUsername(username);
//		return user.map(UserUserDetails::new)
//			.orElseThrow(()->new UsernameNotFoundException("user not found"));
//	}
//}