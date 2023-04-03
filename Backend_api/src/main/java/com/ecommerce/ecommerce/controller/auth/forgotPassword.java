package com.ecommerce.ecommerce.controller.auth;

import com.ecommerce.ecommerce.model.User;
import com.ecommerce.ecommerce.repository.UserRepository;
import com.ecommerce.ecommerce.security.services.AuthService;
import com.ecommerce.ecommerce.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/")
@RequiredArgsConstructor
public class forgotPassword {
    private final AuthService authService;
    private final UserService userService;
    private final UserRepository userRepository;
    private final PasswordEncoder encoder;

    @GetMapping("/password/reset")
    @ResponseBody
    public String getUserByNameAndPassword() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication.isAuthenticated()) {
            System.out.println("true");
        }
        User user = userService.getUserByNameAndPassword();
        return user.getPassword();
    }
}
