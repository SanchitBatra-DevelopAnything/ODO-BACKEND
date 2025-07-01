package com.odo.b2b.backend.ODO_B2B.model.Cart;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter
@Setter
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class CartItem {
        private Double discount_percentage;
        private String id;
        private String imageUrl;
        private String parentBrandName;
        private Double price;
        private Integer quantity;
        private Double slab_1_discount;
        private Double slab_2_discount;
        private Double slab_3_discount;
        private Double slab_1_start;
        private Double slab_2_start;
        private Double slab_3_start;
        private Double slab_1_end;
        private Double slab_2_end;
        private Double slab_3_end;
        private String title;
        private Double totalPrice;
        private Double totalPriceAfterDiscount;
}
