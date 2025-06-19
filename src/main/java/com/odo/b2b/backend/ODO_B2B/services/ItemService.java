package com.odo.b2b.backend.ODO_B2B.services;

import com.odo.b2b.backend.ODO_B2B.mapper.ItemMapper;
import com.odo.b2b.backend.ODO_B2B.model.Area.AreaDTO;
import com.odo.b2b.backend.ODO_B2B.model.Item.ItemDTO;
import com.odo.b2b.backend.ODO_B2B.util.UUIDGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Service
public class ItemService {

    @Autowired
    private ItemMapper itemMapper;


    public String addItem(ItemDTO itemDTO){
        String itemId = new UUIDGenerator().generateUUID();

        Map<String, Object> param = new HashMap<>();
        param.put("itemId", itemId);
        param.put("imgUrl", itemDTO.getImgUrl());
        param.put("itemName", itemDTO.getItemName());
        param.put("itemPrice", itemDTO.getItemPrice());
        param.put("itemPriceGST", Optional.ofNullable(itemDTO.getItemPriceGST())
                .filter(gst -> gst != 0.0)
                .orElse(itemDTO.getItemPrice()));

        param.put("slab_1_discount", itemDTO.getSlab_1_discount());
        param.put("slab_1_start", itemDTO.getSlab_1_start());
        param.put("slab_1_end", itemDTO.getSlab_1_end());

        param.put("slab_2_discount", itemDTO.getSlab_2_discount());
        param.put("slab_2_start", itemDTO.getSlab_2_start());
        param.put("slab_2_end", itemDTO.getSlab_2_end());

        param.put("slab_3_discount", itemDTO.getSlab_3_discount());
        param.put("slab_3_start", itemDTO.getSlab_3_start());
        param.put("slab_3_end", itemDTO.getSlab_3_end());

        param.put("brandId", itemDTO.getBrandId());
        param.put("categoryId" , itemDTO.getCategoryId());

        itemMapper.insertItem(param);
        return itemId;
    }
}
