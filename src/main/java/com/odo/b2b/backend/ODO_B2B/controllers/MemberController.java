package com.odo.b2b.backend.ODO_B2B.controllers;

import com.odo.b2b.backend.ODO_B2B.model.MemberNotification.MemberNotificationDTO;
import com.odo.b2b.backend.ODO_B2B.services.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/v1/members")
@CrossOrigin
public class MemberController {

    @Autowired
    private MemberService memberService;

    @PostMapping("/notifications")
    public ResponseEntity<Map<String, String>> addNotification(@RequestBody MemberNotificationDTO dto) {
        System.out.println("GST received: " + dto.getGST());
        String id = memberService.createNotification(dto);
        Map<String, String> response = new HashMap<>();
        response.put("name", id);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping("/notifications")
    public ResponseEntity<Map<String , MemberNotificationDTO>> getAllNotifications()
    {
        Map<String, MemberNotificationDTO> response = memberService.getAllNotifications();
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/notifications/{notificationId}")
    public ResponseEntity<Void> deleteNotification(@PathVariable String notificationId)
    {
        memberService.deleteMemberNotification(notificationId);
        return ResponseEntity.noContent().build();
    }
}
