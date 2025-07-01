package com.odo.b2b.backend.ODO_B2B.controllers;

import com.odo.b2b.backend.ODO_B2B.model.Cart.CartItem;
import com.odo.b2b.backend.ODO_B2B.model.Cart.SaveCartRequest;
import com.odo.b2b.backend.ODO_B2B.services.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/cart")
@CrossOrigin
public class CartController {
    @Autowired
    private CartService cartService;

    @PutMapping("/save/{memberId}")
    public ResponseEntity<String> saveCart(@PathVariable String memberId,
                                           @RequestBody SaveCartRequest request) {
        cartService.saveCart(memberId, request);
        return ResponseEntity.ok("Cart saved successfully");
    }

    @DeleteMapping("/delete/{memberId}")
    public ResponseEntity<String> deleteCart(@PathVariable String memberId) {
        cartService.deleteCart(memberId);
        return ResponseEntity.ok("Cart deleted successfully");
    }

    @GetMapping("/get/{memberId}")
    public ResponseEntity<Object> getCart(@PathVariable String memberId) {
        List<CartItem> cart = cartService.getCart(memberId);
        if(cart.size()==0)
        {
            return ResponseEntity.ok("null");
        }
        return ResponseEntity.ok(cartService.getCart(memberId));
    }
}
