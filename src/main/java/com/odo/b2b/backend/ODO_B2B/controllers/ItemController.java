package com.odo.b2b.backend.ODO_B2B.controllers;

import com.odo.b2b.backend.ODO_B2B.model.Item.ItemDTO;
import com.odo.b2b.backend.ODO_B2B.model.Item.ItemWithID;
import com.odo.b2b.backend.ODO_B2B.services.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;


@RestController
@CrossOrigin
@RequestMapping("/v1/items")
public class ItemController {

    @Autowired
    private ItemService itemService;

    @GetMapping("/brand/{brandId}")
    public ResponseEntity<Map<String , ItemDTO>> fetchAllItemOfBrand(@PathVariable("brandId") String brandID)
    {
        List<ItemWithID> items = itemService.getAllItemsOfBrand(brandID);

        Map<String, ItemDTO> result = new LinkedHashMap<>();
        for (ItemWithID itemWithId : items) {
            result.put(itemWithId.getId(), itemWithId.getItem());
        }

        return ResponseEntity.ok(result);
    }

    @PostMapping
    public ResponseEntity<Map<String , String>> addItem(@RequestBody ItemDTO payload)
    {
        String id = itemService.addItem(payload);
        Map<String, String> response = new HashMap<>();
        response.put("name", id);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @DeleteMapping("/{itemId}")
    public ResponseEntity<Void> deleteItem(@PathVariable String itemId) {
        itemService.deleteItemById(itemId);
        return ResponseEntity.noContent().build(); // returns status 204 and null body
    }

    @PutMapping("/{itemId}")
    public ResponseEntity<ItemDTO> updateItem(@PathVariable String itemId , @RequestBody ItemDTO payload)
    {
        itemService.updateItem(itemId , payload);
        return ResponseEntity.ok(payload);
    }
}
