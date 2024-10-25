package com.jaljeevan.waterquality.repository;


import com.jaljeevan.waterquality.model.WaterQuality;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WaterQualityRepository extends JpaRepository<WaterQuality, Long> {
    List<WaterQuality> findByVillageId(String villageId);
}

