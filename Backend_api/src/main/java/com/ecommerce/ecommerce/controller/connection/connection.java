package com.ecommerce.ecommerce.controller;

import com.ecommerce.ecommerce.payload.reponse.MessageResponse;
import com.ecommerce.ecommerce.payload.request.ChangePassWord;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/")
@RequiredArgsConstructor
@RestController
public class connection {

    @PostMapping("")
    public ResponseEntity<?> checkConnection (@RequestParam String message) {
        String checkingMessage = message;
        System.out.println(checkingMessage);
        if (checkingMessage.equals("checking")){
            return ResponseEntity.ok().body("success");
        }
        return ResponseEntity.ok().body("fail");
    }
}
