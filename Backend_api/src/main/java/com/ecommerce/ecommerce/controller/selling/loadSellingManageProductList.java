package com.ecommerce.ecommerce.controller.selling;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/selling/manage")
@RequiredArgsConstructor
@RestController
public class loadSellingManageProductList {
    @GetMapping("/info/load")
    public ResponseEntity<?> loadSellingProduct(@RequestParam String id) {
        return ResponseEntity.ok().body("success");
    }
}
