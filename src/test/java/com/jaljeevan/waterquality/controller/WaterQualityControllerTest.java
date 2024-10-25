package com.jaljeevan.waterquality.controller;



import com.jaljeevan.waterquality.model.WaterQuality;
import com.jaljeevan.waterquality.service.WaterQualityService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDate;
import java.util.Collections;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class WaterQualityControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private WaterQualityService waterQualityService;

    @Test
    public void testGetData_NoDataFound() throws Exception {
        Mockito.when(waterQualityService.getData("village1")).thenReturn(Collections.emptyList());

        mockMvc.perform(get("/api/water-quality/village1"))
                .andExpect(status().isNotFound());
    }

    @Test
    public void testIngestData() throws Exception {
        WaterQuality waterQuality = new WaterQuality();
        waterQuality.setVillageId("village1");
        waterQuality.setSampleDate(LocalDate.now());
        waterQuality.setParameters("{\"pH\":7.0,\"chlorine\":0.5}");

        Mockito.when(waterQualityService.save(Mockito.any())).thenReturn(waterQuality);

        mockMvc.perform(post("/api/water-quality")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"villageId\":\"village1\",\"sampleDate\":\"2024-01-01\",\"parameters\":\"{\\\"pH\\\":7.0,\\\"chlorine\\\":0.5}\"}"))
                .andExpect(status().isOk());
    }
}
