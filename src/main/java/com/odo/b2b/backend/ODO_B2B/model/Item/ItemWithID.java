package com.odo.b2b.backend.ODO_B2B.model.Item;

import lombok.*;

@Getter
@Setter
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ItemWithID {
    private String id;
    private ItemDTO item;
}
