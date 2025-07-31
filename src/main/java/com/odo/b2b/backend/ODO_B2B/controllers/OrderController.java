package com.odo.b2b.backend.ODO_B2B.controllers;

import com.odo.b2b.backend.ODO_B2B.model.Order.OrderDTO;
import com.odo.b2b.backend.ODO_B2B.model.Order.OrderWithID;
import com.odo.b2b.backend.ODO_B2B.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RequestMapping("/v1/orders")
@CrossOrigin
@RestController
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping
    public ResponseEntity<Map<String , OrderWithID>> addOrder(@RequestBody OrderDTO order) throws Exception
    {
        orderService.MakeOrderInsertable(order);

        System.out.println("Order received : "+order);
        return null;
    }
}
