package com.project.Fitness.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RecommendationRequest {
    private String userID;
    private String activityID;
    private List<String> improvements;
    private List<String> suggestions;
    private List<String> safety;
}
