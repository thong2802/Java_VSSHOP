package com.ecommerce.ecommerce.controller.account;

import com.ecommerce.ecommerce.model.User;
import com.ecommerce.ecommerce.payload.reponse.MessageResponse;
import com.ecommerce.ecommerce.payload.request.ChangePassWord;
import com.ecommerce.ecommerce.repository.UserRepository;
import com.ecommerce.ecommerce.security.services.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RequestMapping("/api/account/manage")
@RequiredArgsConstructor
@RestController
public class changePassWord {
    private final UserRepository userRepository;
    private final PasswordEncoder encoder;
    @PutMapping ("/password/change")
    public ResponseEntity<?> changePassWord (@RequestParam String id, @RequestBody ChangePassWord changePassWord) {
        User user = userRepository.findById(id).orElseThrow(() -> new UsernameNotFoundException("User Not Found with id: " + id));
        if (user == null) {
            return ResponseEntity.ok().body(new MessageResponse(false, "change password: account is not existed"));
        }
        if (!encoder.matches(changePassWord.getOldPassword(), user.getPassword())) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Current password is incorrect");
        }

        String encodedNewPassword = encoder.encode(changePassWord.getNewPassword());
        user.setPassword(encodedNewPassword);
        userRepository.save(user);

        return ResponseEntity.ok().body(new MessageResponse(true, "change password: success"));
    }
}
