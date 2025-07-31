package com.odo.b2b.backend.ODO_B2B.model.Order;

import lombok.*;

@Data
@ToString
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrderWithID {
    private String orderId;
    private OrderDTO order;
}
