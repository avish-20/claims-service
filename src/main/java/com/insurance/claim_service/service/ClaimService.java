package com.insurance.claim_service.service;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;

import com.insurance.claim_service.dto.ClaimRequest;
import com.insurance.claim_service.entity.Claim;
import com.insurance.claim_service.entity.Policy;
import com.insurance.claim_service.enums.ClaimStatus;
import com.insurance.claim_service.repository.ClaimRepository;

@Service
public class ClaimService {

    public final ClaimCategorizationService claimCategorizationService;
    public final ClaimRepository claimRepository;

    public ClaimService(ClaimCategorizationService claimCategorizationService, ClaimRepository claimRepository) {
        this.claimCategorizationService = claimCategorizationService;
        this.claimRepository = claimRepository;
    }

    public Claim createClaim(ClaimRequest request) {
        // Step 1: Find the policy the claim is being filed against.
        // Policy policy = policyRepository.findById(request.getPolicyId())
        //         .orElseThrow(() -> new RuntimeException("Policy not found with ID: " + request.getPolicyId()));

        // Step 2: Call our AI service to get the assigned level.
        String assignedLevel = claimCategorizationService.assignLevel(request);

        // Step 3: Create a new Claim entity and populate it with data.
        Claim newClaim = new Claim();
        newClaim.setPolicy(new Policy()); // Hardcoded for now; replace with policy.getPolicyNumber() when policy lookup is implemented
        newClaim.setClaimAmount(request.getClaimAmount());
        newClaim.setHospitalName(request.getHospitalName());
        newClaim.setHospitalAddress(request.getHospitalAddress());
        newClaim.setDateOfAdmission(request.getDateOfAdmission());
        newClaim.setHealthIssue(request.getHealthIssue());
        newClaim.setCategory(request.getCategory());

        // Set initial status and level
        newClaim.setClaimStatus(ClaimStatus.PENDING);
        newClaim.setAssignedLevel(assignedLevel);
        newClaim.setSubmissionDate(LocalDateTime.now());

        // Step 4: Save the new claim to the database and return it.
        return claimRepository.save(newClaim);
    }
}
