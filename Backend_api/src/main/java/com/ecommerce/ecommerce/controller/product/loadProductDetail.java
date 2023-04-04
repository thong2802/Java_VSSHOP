package com.ecommerce.ecommerce.controller.product;

import com.ecommerce.ecommerce.model.Product;
import com.ecommerce.ecommerce.payload.reponse.MessageResponse;
import com.ecommerce.ecommerce.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api/product")
@RequiredArgsConstructor
@RestController
public class loadProductDetail {
    private final ProductRepository productRepository;

    @GetMapping("/detail/load")
    public ResponseEntity<?> loadProductDetail (@RequestParam String ProductId) {
        Product product = productRepository.findById(ProductId).orElseThrow(() -> new UsernameNotFoundException("load product detail: product is not existed " + ProductId));
        if (product == null) {
            return ResponseEntity.ok().body(new MessageResponse(false, "load product detail: product is not existed"));
        }
        return ResponseEntity.ok().body("success");
    }
}
