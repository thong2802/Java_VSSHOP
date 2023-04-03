package com.ecommerce.ecommerce.security.services;

import com.ecommerce.ecommerce.model.User;
import com.ecommerce.ecommerce.payload.request.RegistrationRequest;
import com.ecommerce.ecommerce.repository.UserRepository;
import com.ecommerce.ecommerce.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthService {
    private final UserService userService;

    private UserRepository userRepository;

    private PasswordEncoder encoder;
    @Autowired
    public AuthService(UserService userService, UserRepository userRepository, PasswordEncoder encoder) {
        this.userService = userService;
        this.userRepository = userRepository;
        this.encoder = encoder;
    }
    public Optional<User> registerUser(RegistrationRequest signUpRequest) {
        // Create new user's account
        User user = new User(signUpRequest.getName(),
                signUpRequest.getPhone(),
                signUpRequest.getEmail(),
                encoder.encode(signUpRequest.getPassword()));
        userRepository.save(user);
        return Optional.of(user);
    }

}
