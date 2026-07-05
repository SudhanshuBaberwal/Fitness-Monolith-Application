package com.project.Fitness.service;

import com.project.Fitness.dto.RecommendationRequest;
import com.project.Fitness.model.Activity;
import com.project.Fitness.model.Recommendation;
import com.project.Fitness.model.User;
import com.project.Fitness.repository.ActivityRepository;
import com.project.Fitness.repository.RecommendationRepository;
import com.project.Fitness.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RecommendationService {
    private final UserRepository userRepository;
    private final ActivityRepository activityRepository;
    private final RecommendationRepository recommendationRepository;

    public Recommendation generateRecommendation(RecommendationRequest request) {
        User user =userRepository.findById(request.getUserID())
                .orElseThrow(() -> new RuntimeException("User not found" + request.getUserID()));
        Activity activity =activityRepository.findById(request.getActivityID())
                .orElseThrow(() -> new RuntimeException("Activity not found" + request.getActivityID()));

        Recommendation recommendation = Recommendation.builder()
                .user(user)
                .activity(activity)
                .improvements(request.getImprovements())
                .suggestions(request.getSuggestions())
                .safety(request.getSafety())
                .build();

        return recommendationRepository.save(recommendation);
    }

    public List<Recommendation> getUserRecommendation(String userID) {
        return recommendationRepository.findByUserId(userID);
    }

    public List<Recommendation> getActivityRecommendation(String activityID) {
        return recommendationRepository.findByActivityId(activityID);
    }
}
