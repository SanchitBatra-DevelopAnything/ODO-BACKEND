package com.odo.b2b.backend.ODO_B2B.model.Cart;

import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class CartEntity {
    private String cartId;
    private String memberId;
    private String cartItems;
}
