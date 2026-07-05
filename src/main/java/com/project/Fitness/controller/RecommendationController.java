package com.project.Fitness.controller;

import com.project.Fitness.dto.RecommendationRequest;
import com.project.Fitness.model.Recommendation;
import com.project.Fitness.service.RecommendationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/recommendation")
@RequiredArgsConstructor
public class RecommendationController {

    private final RecommendationService recommendationService;

    @PostMapping("/generate")
    public ResponseEntity<Recommendation> generateRecommendation(@RequestBody RecommendationRequest request){
        Recommendation recommendation = recommendationService.generateRecommendation(request);
        return ResponseEntity.ok(recommendation);
    }

    @GetMapping("/user/{userID}")
    public ResponseEntity<List<Recommendation>> getUserRecommendation(@PathVariable String userID){
        List<Recommendation> recommendationList = recommendationService.getUserRecommendation(userID);
        return ResponseEntity.ok(recommendationList);
    }

    @GetMapping("/activity/{activityID}")
    public ResponseEntity<List<Recommendation>> getActivityRecommendation(@PathVariable String activityID){
        List<Recommendation> recommendationList = recommendationService.getActivityRecommendation(activityID);
        return ResponseEntity.ok(recommendationList);
    }
}
