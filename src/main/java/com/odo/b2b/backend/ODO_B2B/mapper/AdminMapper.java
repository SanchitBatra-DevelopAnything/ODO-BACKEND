package com.odo.b2b.backend.ODO_B2B.mapper;

import com.odo.b2b.backend.ODO_B2B.model.Admin.AdminWithID;

import java.util.List;

public interface AdminMapper {
    List<AdminWithID> getAllAdminsWithArea();
}
