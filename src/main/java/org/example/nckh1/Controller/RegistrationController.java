package org.example.nckh1.Controller;

import org.example.nckh1.Entity.Users;
import org.example.nckh1.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class RegistrationController {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;
    public RegistrationController() {
    }
    @GetMapping("/signup")
    public String signup() {
        return "/signup";
    }
    @PostMapping(value ="/signup", consumes = "application/json")
    public ResponseEntity<String> createUser(@RequestBody Users users) {
        users.setPassword(passwordEncoder.encode(users.getPassword()));
        userRepository.save(users);
        return ResponseEntity.ok("User registered successfully");
    }


}
