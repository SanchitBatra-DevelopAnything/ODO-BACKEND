package com.odo.b2b.backend.ODO_B2B.mapper;

import com.odo.b2b.backend.ODO_B2B.model.Area.AreaWithID;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AreaMapper {
    String findAreaIdByName(@Param("areaName") String areaName);
    List<AreaWithID> getAllAreas();
    int deleteAreaById(@Param("areaId") String areaId);
}
