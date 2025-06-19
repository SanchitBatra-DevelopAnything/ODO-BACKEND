package com.odo.b2b.backend.ODO_B2B.services;

import com.odo.b2b.backend.ODO_B2B.mapper.AreaMapper;
import com.odo.b2b.backend.ODO_B2B.model.Admin.AdminDTO;
import com.odo.b2b.backend.ODO_B2B.model.Area.AreaDTO;
import com.odo.b2b.backend.ODO_B2B.model.Area.AreaWithID;
import com.odo.b2b.backend.ODO_B2B.util.UUIDGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AreaService {

    @Autowired
    private AreaMapper areaMapper;

    public List<AreaWithID> getAllAreas() {
        return areaMapper.getAllAreas();
    }

    public void deleteAreaById(String areaId)
    {
        int deleted = areaMapper.deleteAreaById(areaId);
        if (deleted == 0) {
            throw new RuntimeException("Area not found or already deleted: " + areaId);
        }
    }


    public String addArea(AreaDTO payload){
            String areaId = new UUIDGenerator().generateUUID();
            areaMapper.insertArea(areaId ,payload.getAreaName());
            return areaId;
    }
}
