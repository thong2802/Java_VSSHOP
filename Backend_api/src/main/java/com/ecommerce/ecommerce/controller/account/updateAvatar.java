package com.ecommerce.ecommerce.controller.account;

import com.ecommerce.ecommerce.model.User;
import com.ecommerce.ecommerce.payload.reponse.MessageResponse;
import com.ecommerce.ecommerce.payload.request.EditAccount;
import com.ecommerce.ecommerce.payload.request.UpdateAvatar;
import com.ecommerce.ecommerce.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api/account/manage")
@RequiredArgsConstructor
@RestController
public class updateAvatar {
    private final UserRepository userRepository;

    @PutMapping("/avatar/update")
    public ResponseEntity<?> changePassWord (@RequestParam String id, @RequestBody UpdateAvatar updateAvatar){
        User user = userRepository.findById(id).orElseThrow(() -> new UsernameNotFoundException("User Not Found with id: " + id));
        if (user == null) {
            return ResponseEntity.ok().body(new MessageResponse(false, "change password: account is not existed"));
        }
        user.setAvatar(updateAvatar.getAvatar());
        userRepository.save(user);

        return ResponseEntity.ok().body(new MessageResponse(true, "update account avatar: success"));
    }
}
