package com.odo.b2b.backend.ODO_B2B.mapper;

import org.apache.ibatis.annotations.Param;

public interface AreaMapper {
    String findAreaIdByName(@Param("areaName") String areaName);
}
