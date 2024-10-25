package com.jaljeevan.waterquality.service;


import com.jaljeevan.waterquality.model.WaterQuality;
import com.jaljeevan.waterquality.repository.WaterQualityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WaterQualityService {

    @Autowired
    private WaterQualityRepository repository;

    public WaterQuality save(WaterQuality waterQuality) {
        return repository.save(waterQuality);
    }

    public List<WaterQuality> getData(String villageId) {
        System.out.println(villageId);
        return repository.findByVillageId(villageId);
    }

    public String processQuery(String query) {
        // Simple parsing of the query (can be expanded)
        return "Query received: " + query;
    }
}

