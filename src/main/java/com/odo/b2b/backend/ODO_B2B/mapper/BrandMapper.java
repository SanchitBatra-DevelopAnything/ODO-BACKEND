package com.odo.b2b.backend.ODO_B2B.mapper;

import com.odo.b2b.backend.ODO_B2B.model.Brand.BrandDTO;
import org.apache.ibatis.annotations.Param;

public interface BrandMapper {
    void insertBrand(@Param("brandId") String brandId, @Param("dto") BrandDTO dto);
}
