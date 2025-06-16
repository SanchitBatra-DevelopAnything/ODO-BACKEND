package com.odo.b2b.backend.ODO_B2B.controllers;

import com.odo.b2b.backend.ODO_B2B.model.Area.AreaWithID;
import com.odo.b2b.backend.ODO_B2B.model.Brand.BrandDTO;
import com.odo.b2b.backend.ODO_B2B.model.Brand.BrandWithID;
import com.odo.b2b.backend.ODO_B2B.services.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
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

    @GetMapping
    public ResponseEntity<Map<String , BrandDTO>> getAllBrands()
    {
        List<BrandWithID> allBrands = brandService.getAllBrands();
        Map<String, BrandDTO> brandMap = new LinkedHashMap<>();
        for (BrandWithID brandWithId : allBrands) {
            brandMap.put(brandWithId.getId(), brandWithId.getBrand());
        }
        return ResponseEntity.ok(brandMap);
    }
}
