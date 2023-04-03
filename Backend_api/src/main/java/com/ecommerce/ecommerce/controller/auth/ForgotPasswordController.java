package com.ecommerce.ecommerce.controller.auth;

import com.ecommerce.ecommerce.payload.reponse.MessageResponse;
import com.ecommerce.ecommerce.redis.RedisService;
import com.ecommerce.ecommerce.security.services.MailService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;
import java.util.concurrent.TimeUnit;

@RequestMapping("/api/")
@RequiredArgsConstructor
@RestController
public class ForgotPasswordController {
    private final RedisService redisService;
    private final MailService mailService;

    @PostMapping("/forgot-password")
    public ResponseEntity<?> forgotPassword(@RequestParam String email) {
        // generate a random OTP
        String otp = generateOTP();
        System.out.println(otp);
        // store the OTP in Redis
        redisService.set(email, otp);
        System.out.println("redis: " + redisService.get(email));

        redisService.expire(email, 5, TimeUnit.MINUTES); // expire after 5 minutes

        // send the OTP via email
        mailService.sendEmail(email, "Forgot Password", "Your OTP is: " + otp);

        return ResponseEntity.ok().body(new MessageResponse(true, "forgot authentication password: success"));
    }

    private String generateOTP() {
        // generate a 6-digit random number
        int otp = new Random().nextInt(900000) + 100000;
        return Integer.toString(otp);
    }
}

