package com.odo.b2b.backend.ODO_B2B.controllers;

import com.odo.b2b.backend.ODO_B2B.model.Brand.BrandDTO;
import com.odo.b2b.backend.ODO_B2B.services.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.Map;

@RestController
@RequestMapping("/v1/brands")
@CrossOrigin
public class BrandController {

    @Autowired
    private BrandService brandService;

    @PostMapping
    public ResponseEntity<Map<String, String>> addBrand(@RequestBody BrandDTO dto) {
        String id = brandService.addBrand(dto);
        return ResponseEntity.ok(Collections.singletonMap("name", id));
    }
}
