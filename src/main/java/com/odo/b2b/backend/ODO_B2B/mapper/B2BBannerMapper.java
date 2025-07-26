package com.odo.b2b.backend.ODO_B2B.mapper;

import com.odo.b2b.backend.ODO_B2B.model.B2BBanner.B2BBannerWithID;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface B2BBannerMapper {
    List<B2BBannerWithID> getAllBannersWithId();

    int deleteB2BBannerById(@Param("bannerId") String bannerId);

    void insertB2BBanner(@Param("id") String id,
                    @Param("bannerName") String bannerName,
                         @Param("imageUrl") String imageUrl);

}
