package com.odo.b2b.backend.ODO_B2B.model.Member;

import com.odo.b2b.backend.ODO_B2B.model.MemberNotification.MemberNotificationDTO;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class MemberWithID {
    private String memberId;
    private MemberNotificationDTO member;
}
