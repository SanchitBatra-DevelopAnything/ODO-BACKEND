package com.odo.b2b.backend.ODO_B2B.model.MemberNotification;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class MemberNotificationDTO {
    @JsonProperty("GST")
    private String GST;
    private String area;
    private String contact;
    private String name;
    private String shop;
    private String shopAddress;
    private String deviceToken;
    private String latitude;
    private String longitude;
}
