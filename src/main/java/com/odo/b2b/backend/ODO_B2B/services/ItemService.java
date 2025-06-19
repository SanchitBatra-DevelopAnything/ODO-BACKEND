package com.odo.b2b.backend.ODO_B2B.services;

import com.odo.b2b.backend.ODO_B2B.mapper.ItemMapper;
import com.odo.b2b.backend.ODO_B2B.model.Item.ItemDTO;
import com.odo.b2b.backend.ODO_B2B.model.Item.ItemWithID;
import com.odo.b2b.backend.ODO_B2B.util.UUIDGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class ItemService {

    @Autowired
    private ItemMapper itemMapper;

    public void deleteItemById(String itemId)
    {
        int deleted = itemMapper.deleteItemById(itemId);
        if (deleted == 0) {
            throw new RuntimeException("Item not found or already deleted: " + itemId);
        }
    }

    public List<ItemWithID> getAllItemsOfBrand(String brandId)
    {
        return itemMapper.getAllItemsOfBrand(brandId);
    }


    public String addItem(ItemDTO itemDTO){
        String itemId = new UUIDGenerator().generateUUID();

        Map<String , Object> param = getItemParamMap(itemId , itemDTO);
        itemMapper.insertItem(param);
        return itemId;
    }

    public void updateItem(String itemId , ItemDTO payload)
    {
        Map<String , Object> param = getItemParamMap(itemId , payload);
        itemMapper.updateItem(param);
    }

    private Map<String , Object> getItemParamMap(String itemId , ItemDTO itemDTO)
    {
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

        return param;
    }
}
