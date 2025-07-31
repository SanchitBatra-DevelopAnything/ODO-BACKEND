package com.odo.b2b.backend.ODO_B2B.model.Order;

import lombok.*;

@Getter
@Setter
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class OrderItem {
    private String brand;
    private Double discount_percentage;
    private String item;
    private Double price;
    private Double priceAfterDiscount;
    private Integer quantity;
}
