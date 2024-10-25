package com.jaljeevan.waterquality.model;


import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
@Data
@Entity
@Table(name = "water_quality")
public class WaterQuality {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String villageId;

    private LocalDate sampleDate;

    @Column(columnDefinition = "json")
    private String parameters; // Store as JSON

    // Getters and Setters
}
