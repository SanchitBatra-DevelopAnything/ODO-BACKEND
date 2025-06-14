package com.odo.b2b.backend.ODO_B2B.services;

import com.odo.b2b.backend.ODO_B2B.mapper.AreaMapper;
import com.odo.b2b.backend.ODO_B2B.mapper.MemberMapper;
import com.odo.b2b.backend.ODO_B2B.model.MemberNotification.MemberNotificationDTO;
import com.odo.b2b.backend.ODO_B2B.model.MemberNotification.MemberNotificationWithID;
import com.odo.b2b.backend.ODO_B2B.util.UUIDGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Service
public class MemberService {

    @Autowired
    private AreaMapper areaMapper;

    @Autowired
    private MemberMapper memberMapper;

    @Transactional
    public String createNotification(MemberNotificationDTO dto) {
        String areaId = areaMapper.findAreaIdByName(dto.getArea());

        if (areaId == null) {
            throw new IllegalArgumentException("Area not found: " + dto.getArea());
        }

        String id = new UUIDGenerator().generateUUID();

        memberMapper.insertNotification(
                id,
                dto.getGST(),
                areaId,
                dto.getContact(),
                dto.getName(),
                dto.getShop(),
                dto.getShopAddress(),
                dto.getDeviceToken(),
                dto.getLatitude(),
                dto.getLongitude()
        );

        return id;
    }

    public Map<String, MemberNotificationDTO> getAllNotifications() {
        List<MemberNotificationWithID> records = memberMapper.getAllNotificationsWithArea();
        Map<String, MemberNotificationDTO> responseMap = new LinkedHashMap<>();

        for (MemberNotificationWithID record : records) {
            responseMap.put(record.getId(), record.getNotification());
        }

        return responseMap;
    }

}
