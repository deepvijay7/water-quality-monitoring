package com.jaljeevan.waterquality.controller;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.jaljeevan.waterquality.model.WaterQuality;
import com.jaljeevan.waterquality.service.WaterQualityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@RestController
public class ChatbotController {

    @Autowired
    private WaterQualityService waterQualityService;

    @GetMapping("/api/chatbot")
    public ResponseEntity<String> handleQuery(@RequestParam String query) {
        String response;

        String villageId = extractVillageId(query);
        if (villageId.isEmpty()) {
            return ResponseEntity.ok("🤔 Please specify a village ID in your question.");
        }

        List<WaterQuality> results = waterQualityService.getData(villageId);

        if (results.isEmpty()) {
            response = "🤖 Sorry, I couldn't find any water quality data for that village. Please check the village ID.";
        } else {
            // Get the latest data
            WaterQuality latestData = results.get(results.size() - 1);

            // Parse the parameters JSON string
            try {
                ObjectMapper objectMapper = new ObjectMapper();
                Map<String, Object> params = objectMapper.readValue(latestData.getParameters(), Map.class);

                if (query.toLowerCase().contains("ph")) {
                    response = String.format("🌊 The pH value of water in %s is: %s", villageId, params.get("pH"));
                } else if (query.toLowerCase().contains("chlorine")) {
                    response = String.format("🌊 The chlorine level of water in %s is: %s", villageId, params.get("chlorine"));
                } else if (query.toLowerCase().contains("colour")) {
                    response = String.format("🌊 The colour of water in %s is: %s", villageId, params.get("colour"));
                } else {
                    response = "🤔 I didn't quite understand that. Please ask about pH, chlorine, or colour!";
                }
            } catch (Exception e) {
                response = "🤖 Oops! There was an error processing the data.";
            }
        }

        return ResponseEntity.ok(response);
    }

    private String extractVillageId(String query) {
        // Use regex to match "village" followed by whitespace and then capture the village ID
        Pattern pattern = Pattern.compile("village\\s+(\\w+)");
        Matcher matcher = pattern.matcher(query.toLowerCase());

        if (matcher.find()) {
            return matcher.group(1); // Return the captured village ID
        }
        return ""; // Return empty if not found
    }
}


