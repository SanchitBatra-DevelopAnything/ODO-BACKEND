package com.odo.b2b.backend.ODO_B2B.mapper;

import com.odo.b2b.backend.ODO_B2B.model.Brand.BrandDTO;
import com.odo.b2b.backend.ODO_B2B.model.Brand.BrandWithID;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BrandMapper {
    void insertBrand(@Param("brandId") String brandId, @Param("dto") BrandDTO dto);
    List<BrandWithID> getAllBrands();
    void bulkUpdateSortOrders(@Param("brands") List<BrandWithID> brands);
    List<BrandWithID> findBrandsByIds(@Param("ids") List<String> ids);
}
