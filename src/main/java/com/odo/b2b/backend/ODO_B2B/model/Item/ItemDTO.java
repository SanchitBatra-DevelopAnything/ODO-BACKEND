package com.odo.b2b.backend.ODO_B2B.model.Item;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import java.util.List;
import java.util.Map;

@Getter
@Setter
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ItemDTO {
    private String imgUrl;
    private String itemName;
    private double itemPrice;
    private double itemPriceGST;

    private double slab_1_discount;
    private double slab_1_start;
    private double slab_1_end;

    private double slab_2_discount;
    private double slab_2_start;
    private double slab_2_end;

    private double slab_3_discount;
    private double slab_3_start;
    private double slab_3_end;

    private String brandId;
    private String categoryId;

    //for reading request
    private Map<String,AreaWiseSlabData> areaSlabs;

    //for forming response with areaName , it sets the areaSlabs.
    @JsonIgnore
    private List<AreaWiseSlabData> areaWiseSlabData;
}
