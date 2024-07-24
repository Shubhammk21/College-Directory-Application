//package com.CDA.CollegeDirectoryApplication.Services;
//
//import com.CDA.CollegeDirectoryApplication.Modules.User;
//import com.CDA.CollegeDirectoryApplication.Repositories.UserRepo;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.authentication.BadCredentialsException;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.stereotype.Service;
//
//@Service
//public class UserServiceImply implements UserService{
//    @Autowired
//    private UserRepo userRepository;
//    @Autowired
//    private BCryptPasswordEncoder passwordEncoder;
//
//    public User registerUser(User user) {
//        user.setPassword(passwordEncoder.encode(user.getPassword()));
//        return userRepository.save(user);
//    }
//
//    public User authenticateUser(String username, String password) {
//        User user = userRepository.findByUsername(username)
//                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
//        if (passwordEncoder.matches(password, user.getPassword())) {
//            return user;
//        } else {
//            throw new BadCredentialsException("Invalid credentials");
//        }
//    }
//}
