package com.odo.b2b.backend.ODO_B2B.model.Brand;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Data
public class BrandDTO {
    private String brandName;
    private String imageUrl;
    private Integer sortOrder;
}
