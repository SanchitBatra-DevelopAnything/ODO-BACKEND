package com.odo.b2b.backend.ODO_B2B.controllers;

import com.odo.b2b.backend.ODO_B2B.model.Admin.AdminDTO;
import com.odo.b2b.backend.ODO_B2B.services.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/v1/admins")
@CrossOrigin
public class AdminController {

    @Autowired
    private AdminService adminService;

    @GetMapping
    public ResponseEntity<Map<String, AdminDTO>> getAdmins() {
        return ResponseEntity.ok(adminService.getAdminsAsMap());
    }

    @PostMapping
    public ResponseEntity<Map<String , String>> addSubAdmin(@RequestBody AdminDTO payload) {
        String id = adminService.addSubAdmin(payload);
        Map<String, String> response = new HashMap<>();
        response.put("name", id);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @DeleteMapping("/{adminId}")
    public ResponseEntity<Void> deleteSubAdmin(@PathVariable String adminId)
    {
        adminService.deleteSubAdminById(adminId);
        return ResponseEntity.noContent().build();
    }

}
