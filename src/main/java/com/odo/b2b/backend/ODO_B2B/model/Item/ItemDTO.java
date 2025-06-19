package com.odo.b2b.backend.ODO_B2B.model.Item;

import lombok.*;

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
}
