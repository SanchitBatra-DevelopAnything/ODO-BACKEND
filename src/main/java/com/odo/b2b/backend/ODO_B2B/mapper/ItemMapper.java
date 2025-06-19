package com.odo.b2b.backend.ODO_B2B.mapper;

import org.apache.ibatis.annotations.Param;

import java.util.Map;

public interface ItemMapper {
    void insertItem(Map<String , Object> param);
    int deleteItemById(@Param("itemId") String itemId);
}
