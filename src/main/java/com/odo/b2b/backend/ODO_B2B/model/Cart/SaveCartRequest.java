package com.odo.b2b.backend.ODO_B2B.model.Cart;

import lombok.*;

import java.util.List;

@Getter
@Setter
@ToString
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SaveCartRequest {
    private List<CartItem> items;
}
