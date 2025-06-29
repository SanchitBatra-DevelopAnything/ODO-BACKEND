package com.odo.b2b.backend.ODO_B2B.model.Item;

import lombok.*;

@Getter
@Setter
@ToString
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AreaWiseSlabData {
    private String areaId;
    private double slab_1_discount;
    private double slab_1_start;
    private double slab_1_end;

    private double slab_2_discount;
    private double slab_2_start;
    private double slab_2_end;

    private double slab_3_discount;
    private double slab_3_start;
    private double slab_3_end;
}
