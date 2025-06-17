package com.odo.b2b.backend.ODO_B2B.services;

import com.odo.b2b.backend.ODO_B2B.mapper.BrandMapper;
import com.odo.b2b.backend.ODO_B2B.model.Brand.BrandDTO;
import com.odo.b2b.backend.ODO_B2B.model.Brand.BrandWithID;
import com.odo.b2b.backend.ODO_B2B.util.UUIDGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class BrandService {

    @Autowired
    private BrandMapper brandMapper;

    public String addBrand(BrandDTO dto) {
        String id = new UUIDGenerator().generateUUID();
        brandMapper.insertBrand(id, dto);
        return id;
    }

    public List<BrandWithID> getAllBrands()
    {
        return brandMapper.getAllBrands();
    }

    public Map<String, BrandDTO> updateSortOrders(Map<String, BrandDTO> inputMap) {
        // Step 1: Convert to BrandWithID list
        List<BrandWithID> brandList = inputMap.entrySet().stream()
                .map(entry -> {
                    BrandWithID b = new BrandWithID();
                    b.setId(entry.getKey());
                    b.setBrand(entry.getValue());
                    return b;
                })
                .collect(Collectors.toList());

        // Step 2: Update sortOrder in DB
        brandMapper.bulkUpdateSortOrders(brandList);

        return inputMap;
    }

}
