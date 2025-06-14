package com.odo.b2b.backend.ODO_B2B.mapper;

import com.odo.b2b.backend.ODO_B2B.model.Admin.AdminWithID;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AdminMapper {
    List<AdminWithID> getAllAdminsWithArea();

    void insertAdmin(@Param("id") String id,
                     @Param("username") String username,
                     @Param("password") String password,
                     @Param("type") String type,
                     @Param("areaId") String areaId);

    int deleteSubAdminById(@Param("subAdminId") String subAdminId);
}
