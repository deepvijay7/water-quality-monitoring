package com.jaljeevan.waterquality.controller;

import com.jaljeevan.waterquality.exception.ResourceNotFoundException;
import com.jaljeevan.waterquality.model.WaterQuality;
import com.jaljeevan.waterquality.service.WaterQualityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/water-quality")
public class WaterQualityController {

    @Autowired
    private WaterQualityService waterQualityService;

    @PostMapping
    public ResponseEntity<WaterQuality> ingestData(@RequestBody WaterQuality waterQuality) {
        WaterQuality savedData = waterQualityService.save(waterQuality);
        return ResponseEntity.ok(savedData);
    }

    @GetMapping("/{villageId}")
    public ResponseEntity<List<WaterQuality>> getData(@PathVariable String villageId) {
        List<WaterQuality> data = waterQualityService.getData(villageId);

        if (data.isEmpty()) {
            throw new ResourceNotFoundException("No water quality data found for village ID: " + villageId);
        }

        return ResponseEntity.ok(data);
    }
}

