package com.odo.b2b.backend.ODO_B2B.model.Admin;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class AdminWithID {
    private String id;
    private AdminDTO admin;
}
