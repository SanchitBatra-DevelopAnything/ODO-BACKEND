package com.odo.b2b.backend.ODO_B2B.mapper;

import com.odo.b2b.backend.ODO_B2B.model.Item.ItemWithID;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface ItemMapper {
    void insertItem(Map<String , Object> param);
    int deleteItemById(@Param("itemId") String itemId);
    List<ItemWithID> getAllItemsOfBrand(@Param("brandId") String brandId);
}
