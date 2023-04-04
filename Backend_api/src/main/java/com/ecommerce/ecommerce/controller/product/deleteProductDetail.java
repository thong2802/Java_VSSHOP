package com.ecommerce.ecommerce.controller.product;

import com.ecommerce.ecommerce.payload.request.ChangePassWord;
import com.ecommerce.ecommerce.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api/product")
@RequiredArgsConstructor
@RestController
public class deleteProductDetail {
    private final ProductRepository productRepository;

    @DeleteMapping("/manage/detail/delete")
    public ResponseEntity<?> addProduct (@RequestParam String productId) {

        return ResponseEntity.ok().body("success");
    }
}
