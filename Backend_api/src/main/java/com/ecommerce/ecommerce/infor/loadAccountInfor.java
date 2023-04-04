package com.ecommerce.ecommerce.controller.infor;

import com.ecommerce.ecommerce.model.User;
import com.ecommerce.ecommerce.payload.reponse.LoadAccount;
import com.ecommerce.ecommerce.payload.reponse.MessageResponse;
import com.ecommerce.ecommerce.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;


@RequiredArgsConstructor
@RestController
@RequestMapping("/api/account/manage")
public class loadAccountInfor {
    private final UserRepository userRepository;
    @GetMapping("/info/load")
    public ResponseEntity<?> loadAccountInfor(@RequestParam String id) {
        User user = userRepository.findById(id).orElseThrow(() -> new UsernameNotFoundException("User Not Found with id: " + id));
        if (user == null) {
            return ResponseEntity.ok().body(new MessageResponse(false, "account is not existed"));
        }
        return ResponseEntity.ok().body(new LoadAccount(
                user.getId(),
                user.getAvatar(),
                user.getCart(),
                user.getEmail(),
                user.getUsername(),
                user.getOrder(), user.
                getPhone()));
    }
}
