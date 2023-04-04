package com.ecommerce.ecommerce.controller.product;

import com.ecommerce.ecommerce.payload.request.ChangePassWord;
import com.ecommerce.ecommerce.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api/product")
@RequiredArgsConstructor
@RestController
public class editProductDetail {
    private final ProductRepository productRepository;
    @PostMapping("/manage/detail/edit")
    public ResponseEntity<?> editProductDetail (@RequestParam String id, @RequestBody ChangePassWord changePassWord) {

        return ResponseEntity.ok().body("success");
    }
}
