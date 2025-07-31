package com.odo.b2b.backend.ODO_B2B.controllers;

import com.odo.b2b.backend.ODO_B2B.model.Order.OrderDTO;
import com.odo.b2b.backend.ODO_B2B.model.Order.OrderWithID;
import com.odo.b2b.backend.ODO_B2B.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@RequestMapping("/v1/orders")
@CrossOrigin
@RestController
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping
    public ResponseEntity<Map<String , String>> addOrder(@RequestBody OrderDTO order) {
        try{
            orderService.MakeOrderInsertable(order);
            String orderId = orderService.insertOrder(order);
            HashMap<String, String> response = new HashMap<>();
            response.put("name" , orderId);
            return ResponseEntity.status(HttpStatus.CREATED).body(response);
        }catch (Exception e) {
            Map<String, String> error = new HashMap<>();
            error.put("error", "Failed to insert order");
            error.put("details", e.getMessage());

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(error);
        }
    }
}
