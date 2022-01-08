package com.redislabs.edu.redi2read.controllers;

import com.redislabs.edu.redi2read.services.RecommendationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
@RequestMapping("/api/recommendations")
public class RecommendationController {
    @Autowired
    private RecommendationService recommendationService;
    @GetMapping("/user/{userId}")
    public Set<String> userRecommendations(@PathVariable("userId") String userId) {
        return recommendationService.getBookRecommendationsFromCommonPurchasesForUser(userId);
    }
    @GetMapping("/isbn/{isbn}/pairings")
    public Set<String> frequentPairings(@PathVariable("isbn") String isbn) {
        return recommendationService.getFrequentlyBoughtTogether(isbn);
    }
}
