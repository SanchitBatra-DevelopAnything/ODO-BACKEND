package com.odo.b2b.backend.ODO_B2B.model.Admin;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Data
public class AdminDTO {
    private String username;
    private String password;
    private String type;
    private String area;
}
