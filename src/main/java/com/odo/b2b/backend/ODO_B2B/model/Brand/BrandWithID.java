package com.odo.b2b.backend.ODO_B2B.model.Brand;

import lombok.*;

@Getter
@Setter
@ToString
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BrandWithID {
    private String id;
    private BrandDTO brand;
}
