package com.odo.b2b.backend.ODO_B2B.services;

import com.odo.b2b.backend.ODO_B2B.mapper.ItemMapper;
import com.odo.b2b.backend.ODO_B2B.model.Item.AreaWiseSlabData;
import com.odo.b2b.backend.ODO_B2B.model.Item.ItemDTO;
import com.odo.b2b.backend.ODO_B2B.model.Item.ItemWithID;
import com.odo.b2b.backend.ODO_B2B.util.UUIDGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

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
        List<ItemWithID> rawList = itemMapper.getAllItemsOfBrand(brandId);
        setAreaWiseSlabDataMap(rawList);
        return rawList;
    }

    private void setAreaWiseSlabDataMap(List<ItemWithID> rawList)
    {
        for(ItemWithID itemWithID:rawList)
        {
            Map<String , AreaWiseSlabData> result = new HashMap<>();
            if(itemWithID!=null && itemWithID.getItem()!=null && itemWithID.getItem().getAreaWiseSlabData()!=null)
            {
                List<AreaWiseSlabData> slabsDataFromDB = itemWithID.getItem().getAreaWiseSlabData();
                for(AreaWiseSlabData slabInDB : slabsDataFromDB)
                {
                    if(slabInDB.getAreaId()!=null && slabInDB.getAreaName()!=null)
                    {
                        result.put(slabInDB.getAreaName().toLowerCase().trim(), slabInDB);
                    }
                }
            }
            itemWithID.getItem().setAreaSlabs(result);
        }
    }


    @Transactional
    public String addItem(ItemDTO itemDTO){
        String itemId = new UUIDGenerator().generateUUID();
        Map<String , Object> param = getItemParamMap(itemId , itemDTO);
        itemMapper.insertItem(param);
        if(itemDTO.getAreaSlabs()!=null && itemDTO.getAreaSlabs().size()!=0)
        {
            //area wise slabs are given for this item , hence add it.
            for(String areaName : itemDTO.getAreaSlabs().keySet())
            {
                if(itemDTO.getAreaSlabs().get(areaName)!=null) {
                    Map<String , Object> areaSlabParam = getAreaSlabParamMap(itemId , itemDTO.getAreaSlabs().get(areaName));
                    itemMapper.insertAreaSlabForItem(areaSlabParam);
                }
            }
        }
        return itemId;
    }

    @Transactional
    public void updateItem(String itemId , ItemDTO payload)
    {
        Map<String , Object> param = getItemParamMap(itemId , payload);
        //updateItem in item table.
        itemMapper.updateItem(param);

        //delete all areaSlabs for item as they can now use default and need to be deleted.
        itemMapper.deleteAreaSlabs(itemId);

        //re-insert new slabs with this request.
        if(payload.getAreaSlabs()!=null && payload.getAreaSlabs().size()!=0)
        {
            //area wise slabs are given for this item , hence add it.
            for(String areaName : payload.getAreaSlabs().keySet())
            {
                if(payload.getAreaSlabs().get(areaName)!=null) {
                    Map<String , Object> areaSlabParam = getAreaSlabParamMap(itemId , payload.getAreaSlabs().get(areaName));
                    itemMapper.insertAreaSlabForItem(areaSlabParam);
                }
            }
        }
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

    private Map<String , Object> getAreaSlabParamMap(String itemId, AreaWiseSlabData itemDTO)
    {
        Map<String, Object> param = new HashMap<>();
        param.put("itemId", itemId);
        param.put("areaId" , itemDTO.getAreaId());
        param.put("slab_1_discount", itemDTO.getSlab_1_discount());
        param.put("slab_1_start", itemDTO.getSlab_1_start());
        param.put("slab_1_end", itemDTO.getSlab_1_end());
        param.put("slab_2_discount", itemDTO.getSlab_2_discount());
        param.put("slab_2_start", itemDTO.getSlab_2_start());
        param.put("slab_2_end", itemDTO.getSlab_2_end());
        param.put("slab_3_discount", itemDTO.getSlab_3_discount());
        param.put("slab_3_start", itemDTO.getSlab_3_start());
        param.put("slab_3_end", itemDTO.getSlab_3_end());
        return param;
    }
}
