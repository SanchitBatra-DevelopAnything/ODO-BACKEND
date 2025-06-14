package com.odo.b2b.backend.ODO_B2B.mapper;

import com.odo.b2b.backend.ODO_B2B.model.MemberNotification.MemberNotificationWithID;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MemberMapper {
    void insertNotification(@Param("id") String id,
                            @Param("GST") String GST,
                            @Param("areaId") String areaId,
                            @Param("contact") String contact,
                            @Param("name") String name,
                            @Param("shop") String shop,
                            @Param("shopAddress") String shopAddress,
                            @Param("deviceToken") String deviceToken,
                            @Param("latitude") String latitude,
                            @Param("longitude") String longitude);

    List<MemberNotificationWithID> getAllNotificationsWithArea();

    int deleteMemberNotification(@Param("notificationId") String notificationId);
}
