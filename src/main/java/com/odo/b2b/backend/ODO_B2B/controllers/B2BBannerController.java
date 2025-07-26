package com.odo.b2b.backend.ODO_B2B.controllers;

import com.odo.b2b.backend.ODO_B2B.model.B2BBanner.B2BBannerDTO;
import com.odo.b2b.backend.ODO_B2B.services.B2BBannerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@CrossOrigin
@RequestMapping("/v1/B2BBanners")
public class B2BBannerController {

    @Autowired
    private B2BBannerService B2BBannerService;

    @GetMapping
    public ResponseEntity<Map<String, B2BBannerDTO>> getB2BBanners() {
        return ResponseEntity.ok(B2BBannerService.getAllBanners());
    }

    @PostMapping
    public ResponseEntity<Map<String , String>> addB2BBanner(@RequestBody B2BBannerDTO payload) {
        String id = B2BBannerService.addBanner(payload);
        Map<String, String> response = new HashMap<>();
        response.put("name", id);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @DeleteMapping("/{bannerId}")
    public ResponseEntity<Void> deleteB2BBanner(@PathVariable String bannerId)
    {
        B2BBannerService.deleteBannerById(bannerId);
        return ResponseEntity.noContent().build();
    }
}
