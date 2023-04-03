package com.ecommerce.ecommerce.controller.auth;

import com.ecommerce.ecommerce.model.User;
import com.ecommerce.ecommerce.payload.reponse.MessageResponse;
import com.ecommerce.ecommerce.redis.RedisService;
import com.ecommerce.ecommerce.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/")
@RequiredArgsConstructor
@RestController
public class ResetPassword {
    private final RedisService redisService;
    private final UserRepository userRepository;
    private final PasswordEncoder encoder;
    @PostMapping("/reset-password")
    public ResponseEntity<?> resetPassword(@RequestParam String email, @RequestParam String otp, @RequestParam String password) {
        // check if the OTP is valid
        String savedOtp = (String) redisService.get(email);
        if (!otp.equals(savedOtp)) {
            return ResponseEntity.ok().body(new MessageResponse(false, "reset authentication password: verify code is wrong"));
        }
        // reset the password
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("User Not Found with username: " + email));
        System.out.println(user);
        user.setPassword(encoder.encode(password));
        userRepository.save(user);

        // delete the OTP from Redis
        redisService.delete(email);
        return ResponseEntity.ok().body(new MessageResponse(true, "reset authentication password: success"));
    }
}
