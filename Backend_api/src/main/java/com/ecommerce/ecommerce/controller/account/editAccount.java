package com.ecommerce.ecommerce.controller.account;

import com.ecommerce.ecommerce.model.User;
import com.ecommerce.ecommerce.payload.reponse.MessageResponse;
import com.ecommerce.ecommerce.payload.request.EditAccount;
import com.ecommerce.ecommerce.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api/account/manage")
@RequiredArgsConstructor
@RestController
public class editAccount {
    private final UserRepository userRepository;

    @PutMapping("/info/edit")
    public ResponseEntity<?> changePassWord (@RequestParam String id, @RequestBody EditAccount editAccount){
        User user = userRepository.findById(id).orElseThrow(() -> new UsernameNotFoundException("User Not Found with id: " + id));
        if (user == null) {
            return ResponseEntity.ok().body(new MessageResponse(false, "change password: account is not existed"));
        }
        if (userRepository.existsByEmail(editAccount.getEmail())) {
            return ResponseEntity.badRequest().body(new MessageResponse(false,"Email is existed!"));
        }
        if (userRepository.existsByPhone(editAccount.getPhone())) {
            return ResponseEntity.badRequest().body(new MessageResponse(false, "The number phone is existed!"));
        }
        user.setUsername(editAccount.getUsername());
        user.setEmail(editAccount.getEmail());
        user.setPhone(editAccount.getPhone());
        userRepository.save(user);

        return ResponseEntity.ok().body(new MessageResponse(true, "edit account info: success"));
    }
}
