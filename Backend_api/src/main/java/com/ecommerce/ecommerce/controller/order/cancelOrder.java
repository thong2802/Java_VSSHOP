package com.ecommerce.ecommerce.controller.order;

import com.ecommerce.ecommerce.payload.request.ChangePassWord;
import com.ecommerce.ecommerce.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api/order/")
@RequiredArgsConstructor
@RestController
public class cancelOrder {
    private final OrderRepository orderRepository;
    @GetMapping("/cancel")
    public ResponseEntity<?> cancelOrder (@RequestParam String accountId, @RequestBody ChangePassWord changePassWord) {

        return ResponseEntity.ok().body("success");
    }
}
