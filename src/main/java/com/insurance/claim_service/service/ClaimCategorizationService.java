package com.insurance.claim_service.service;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.stereotype.Service;

import com.insurance.claim_service.dto.ClaimRequest;

@Service
public class ClaimCategorizationService {

    // Thresholds for categorization
    private static final BigDecimal LEVEL_1_MAX_AMOUNT = new BigDecimal("50000");
    private static final BigDecimal LEVEL_2_MAX_AMOUNT = new BigDecimal("500000");
    private static final List<String> HIGH_RISK_KEYWORDS = List.of("cardiac", "cancer", "accident", "heart", "transplant");
    
    public String assignLevel(ClaimRequest request) {
        String healthIssue = request.getHealthIssue().toLowerCase();

        // Rule 1: Check for high-risk keywords first. This overrides everything else.
        for (String keyword : HIGH_RISK_KEYWORDS) {
            if (healthIssue.contains(keyword)) {
                return "L3"; // Escalate to Level 3 immediately
            }
        }

        // Rule 2: Categorize based on the claim amount
        BigDecimal amount = request.getClaimAmount();
        if (amount.compareTo(LEVEL_1_MAX_AMOUNT) <= 0) {
            return "L1"; // Low amount, fast-track
        } else if (amount.compareTo(LEVEL_2_MAX_AMOUNT) <= 0) {
            return "L2"; // Medium amount, standard review
        } else {
            return "L3"; // High amount, expert review
        }
    }
}
