package com.odo.b2b.backend.ODO_B2B.controllers;


import com.odo.b2b.backend.ODO_B2B.model.Area.AreaDTO;
import com.odo.b2b.backend.ODO_B2B.model.Area.AreaWithID;
import com.odo.b2b.backend.ODO_B2B.services.AreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin
@RequestMapping("/v1/areas")
public class AreaController {

    @Autowired
    private AreaService areaService;


    @GetMapping
    public ResponseEntity<Map<String, AreaDTO>> getAllAreas() {
        List<AreaWithID> areas = areaService.getAllAreas();

        Map<String, AreaDTO> result = new LinkedHashMap<>();
        for (AreaWithID areaWithId : areas) {
            result.put(areaWithId.getId(), areaWithId.getArea());
        }

        return ResponseEntity.ok(result);
    }

    @DeleteMapping("/{areaId}")
    public ResponseEntity<Void> deleteArea(@PathVariable String areaId) {
        areaService.deleteAreaById(areaId);
        return ResponseEntity.noContent().build(); // returns status 204 and null body
    }
}
