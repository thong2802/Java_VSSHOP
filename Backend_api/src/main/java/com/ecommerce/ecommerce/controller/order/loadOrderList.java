package com.ecommerce.ecommerce.controller.order;

import com.ecommerce.ecommerce.payload.request.ChangePassWord;
import com.ecommerce.ecommerce.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/order/")
public class loadOrderList {
    private final OrderRepository orderRepository;
    @GetMapping("/list/load")
    public ResponseEntity<?> loadCartItem (@RequestParam String accountId, @RequestBody ChangePassWord changePassWord) {

        return ResponseEntity.ok().body("success");
    }
}
