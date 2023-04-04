package com.ecommerce.ecommerce.controller.order;

import com.ecommerce.ecommerce.model.Order;
import com.ecommerce.ecommerce.model.User;
import com.ecommerce.ecommerce.payload.reponse.MessageResponse;
import com.ecommerce.ecommerce.payload.request.ChangePassWord;
import com.ecommerce.ecommerce.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/order/")
public class confirmOrder {
    private final OrderRepository orderRepository;
    @GetMapping("/confirm")
    public ResponseEntity<?> confirmOrder (@RequestParam String orderId) {
        Order user = orderRepository.findById(orderId).orElseThrow(() -> new UsernameNotFoundException("Order Not Found with id: " + orderId));
        if (user == null) {
            return ResponseEntity.ok().body(new MessageResponse(false, "confirm order: order is not existed"));
        }
        Order order = new Order();
        order.setState("confirmed");
        orderRepository.save(order);

        return ResponseEntity.ok().body(new MessageResponse(true, "confirm order: success"));
    }
}
