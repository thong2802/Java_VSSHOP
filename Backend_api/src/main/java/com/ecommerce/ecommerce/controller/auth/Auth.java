package com.ecommerce.ecommerce.controller.auth;

import com.ecommerce.ecommerce.payload.request.LoginRequest;
import com.ecommerce.ecommerce.payload.request.RegistrationRequest;
import com.ecommerce.ecommerce.repository.UserRepository;
import com.ecommerce.ecommerce.security.jwt.JwtUtils;
import com.ecommerce.ecommerce.payload.reponse.MessageResponse;
import com.ecommerce.ecommerce.payload.reponse.UserInfoResponse;
import com.ecommerce.ecommerce.security.services.UserDetailsImpl;
import com.ecommerce.ecommerce.security.services.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseCookie;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class Auth {

    private final AuthService authService;

    private final AuthenticationManager authenticationManager;
    private final UserRepository userRepository;

    private final PasswordEncoder encoder;

    private final JwtUtils jwtUtils;


    @PostMapping("/login")
    @ResponseBody
    public ResponseEntity<?> authenticateUser(@RequestBody @Validated  LoginRequest loginRequest) {
        if (loginRequest.getName() == null || loginRequest.getPassword() == null) {
            throw new UsernameNotFoundException("UserName or Password is Empty");
        }
        Authentication authentication = authenticationManager
                .authenticate(new UsernamePasswordAuthenticationToken(loginRequest.getName(), loginRequest.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);

        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();

        ResponseCookie jwtCookie = jwtUtils.generateJwtCookie(userDetails);
        return ResponseEntity.ok().header(HttpHeaders.SET_COOKIE, jwtCookie.toString())
                .body(new UserInfoResponse(userDetails.getId(),
                        userDetails.getUsername(),
                        userDetails.getEmail(),
                        jwtCookie.getValue(),
                        userDetails.getStore_id(),
                        userDetails.getOrders(),
                        userDetails.getCart()));
    }

    @PostMapping("/register")
    @ResponseBody
    public ResponseEntity<?> registerUser(@RequestBody @Validated  RegistrationRequest signUpRequest) {
        if (userRepository.existsByUsername(signUpRequest.getName())) {
            return ResponseEntity.badRequest().body(new MessageResponse(false, " Username is already taken!"));
        }
        if (userRepository.existsByEmail(signUpRequest.getEmail())) {
            return ResponseEntity.badRequest().body(new MessageResponse(false,"Email is already in use!"));
        }
        if (userRepository.existsByPhone(signUpRequest.getPhone())) {
            return ResponseEntity.badRequest().body(new MessageResponse(false, "The number phone already in use!"));
        }
        authService.registerUser(signUpRequest);

        return ResponseEntity.ok(new MessageResponse(true, "User registered successfully!"));
    }

    @PostMapping("/logout")
    @ResponseBody
    public ResponseEntity<?> logoutUser() {
        ResponseCookie cookie = jwtUtils.getCleanJwtCookie();
        return ResponseEntity.ok().header(HttpHeaders.SET_COOKIE, cookie.toString())
                .body(new MessageResponse(true,"You've been signed out!"));
    }
}

