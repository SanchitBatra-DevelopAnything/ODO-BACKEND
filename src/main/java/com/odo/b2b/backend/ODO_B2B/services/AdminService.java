package com.odo.b2b.backend.ODO_B2B.services;

import com.odo.b2b.backend.ODO_B2B.mapper.AdminMapper;
import com.odo.b2b.backend.ODO_B2B.model.Admin.AdminDTO;
import com.odo.b2b.backend.ODO_B2B.model.Admin.AdminWithID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class AdminService {
    @Autowired
    private AdminMapper adminMapper;

    public Map<String, AdminDTO> getAdminsAsMap() {
        List<AdminWithID> adminList = adminMapper.getAllAdminsWithArea();
        return adminList.stream()
                .collect(Collectors.toMap(AdminWithID::getId, AdminWithID::getAdmin));
    }
}
