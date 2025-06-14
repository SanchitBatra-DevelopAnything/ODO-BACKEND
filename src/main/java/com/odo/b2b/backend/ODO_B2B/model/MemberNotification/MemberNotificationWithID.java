package com.odo.b2b.backend.ODO_B2B.model.MemberNotification;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class MemberNotificationWithID {
    private String id;
    private MemberNotificationDTO notification;

}
