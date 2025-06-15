package com.odo.b2b.backend.ODO_B2B.services;

import com.odo.b2b.backend.ODO_B2B.mapper.BrandMapper;
import com.odo.b2b.backend.ODO_B2B.model.Brand.BrandDTO;
import com.odo.b2b.backend.ODO_B2B.util.UUIDGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BrandService {

    @Autowired
    private BrandMapper brandMapper;

    public String addBrand(BrandDTO dto) {
        String id = new UUIDGenerator().generateUUID();
        brandMapper.insertBrand(id, dto);
        return id;
    }
}
