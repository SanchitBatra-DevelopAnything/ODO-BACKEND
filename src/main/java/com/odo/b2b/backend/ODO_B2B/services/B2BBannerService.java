package com.odo.b2b.backend.ODO_B2B.services;

import com.odo.b2b.backend.ODO_B2B.mapper.B2BBannerMapper;
import com.odo.b2b.backend.ODO_B2B.model.Admin.AdminDTO;
import com.odo.b2b.backend.ODO_B2B.model.Admin.AdminWithID;
import com.odo.b2b.backend.ODO_B2B.model.Area.AreaDTO;
import com.odo.b2b.backend.ODO_B2B.model.B2BBanner.B2BBannerDTO;
import com.odo.b2b.backend.ODO_B2B.model.B2BBanner.B2BBannerWithID;
import com.odo.b2b.backend.ODO_B2B.util.UUIDGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class B2BBannerService {

    @Autowired
    private B2BBannerMapper b2BBannerMapper;

    public Map<String, B2BBannerDTO> getAllBanners() {
        List<B2BBannerWithID> bannersList = b2BBannerMapper.getAllBannersWithId();
        return bannersList.stream()
                .collect(Collectors.toMap(B2BBannerWithID::getId, B2BBannerWithID::getB2BBanner));
    }

    public String addBanner(B2BBannerDTO payload){
        String bannerId = new UUIDGenerator().generateUUID();
        b2BBannerMapper.insertB2BBanner(bannerId, payload.getBannerName(), payload.getImageUrl());
        return bannerId;
    }

    public void deleteBannerById(String bannerId)
    {
        int deleted = b2BBannerMapper.deleteB2BBannerById(bannerId);
        if (deleted == 0) {
            throw new RuntimeException("Banner not found or already deleted: " + bannerId);
        }
    }
}
