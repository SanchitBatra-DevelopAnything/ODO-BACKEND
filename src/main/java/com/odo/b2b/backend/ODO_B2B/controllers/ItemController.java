package com.odo.b2b.backend.ODO_B2B.controllers;

import com.odo.b2b.backend.ODO_B2B.model.Item.ItemDTO;
import com.odo.b2b.backend.ODO_B2B.services.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;


@RestController
@CrossOrigin
@RequestMapping("/v1/items")
public class ItemController {

    @Autowired
    private ItemService itemService;

    @PostMapping
    public ResponseEntity<Map<String , String>> addItem(@RequestBody ItemDTO payload)
    {
        String id = itemService.addItem(payload);
        Map<String, String> response = new HashMap<>();
        response.put("name", id);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}
