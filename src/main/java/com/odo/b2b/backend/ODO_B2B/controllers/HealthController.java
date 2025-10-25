package com.odo.b2b.backend.ODO_B2B.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthController {

    @GetMapping("/health")
    public String checkStatus()
    {
        return "ODO-B2B is up and running.";
    }
}
