package com.odo.b2b.backend.ODO_B2B.services;

import com.odo.b2b.backend.ODO_B2B.mapper.AdminMapper;
import com.odo.b2b.backend.ODO_B2B.mapper.AreaMapper;
import com.odo.b2b.backend.ODO_B2B.model.Admin.AdminDTO;
import com.odo.b2b.backend.ODO_B2B.model.Admin.AdminWithID;
import com.odo.b2b.backend.ODO_B2B.util.UUIDGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class AdminService {
    @Autowired
    private AdminMapper adminMapper;

    @Autowired
    private AreaMapper areaMapper;

    public Map<String, AdminDTO> getAdminsAsMap() {
        List<AdminWithID> adminList = adminMapper.getAllAdminsWithArea();
        return adminList.stream()
                .collect(Collectors.toMap(AdminWithID::getId, AdminWithID::getAdmin));
    }

    @Transactional
    public String addSubAdmin(AdminDTO payload){
        if("Sub".equalsIgnoreCase(payload.getType()))
        {
            String areaId = null;
            areaId = areaMapper.findAreaIdByName(payload.getArea());
            if (areaId == null) {
                throw new IllegalArgumentException("Area not found in area's table: " + payload.getArea());
            }

            String adminId = new UUIDGenerator().generateUUID();

            adminMapper.insertAdmin(adminId ,payload.getUsername(), payload.getPassword(), payload.getType(), areaId);
            return adminId;
        }
        else
        {
            throw new IllegalArgumentException("Please change adminType to Sub to insert into DB through this route.");
        }
    }
}
