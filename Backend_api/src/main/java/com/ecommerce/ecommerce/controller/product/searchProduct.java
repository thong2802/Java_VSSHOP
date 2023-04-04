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
public class searchProduct {
    private final ProductRepository productRepository;

    @PostMapping("/search")
    public ResponseEntity<?> searchProduct (@RequestBody String searchInput) {
        Product product = productRepository.findByName(searchInput).orElseThrow(() -> new UsernameNotFoundException("load product detail: product is not existed " + searchInput));
        if (product == null) {
            return ResponseEntity.ok().body(new MessageResponse(false, "load product detail: product is not existed"));
        }
        return ResponseEntity.ok().body("success" + product);
    }
}
