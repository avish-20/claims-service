package com.insurance.claim_service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.insurance.claim_service.dto.ClaimRequest;
import com.insurance.claim_service.entity.Claim;
import com.insurance.claim_service.service.ClaimService;

@RestController
@RequestMapping("/api/claims")
public class ClaimController {
    @Autowired
    private ClaimService claimService;

    // User API: Submit a new claim
    @PostMapping
    public ResponseEntity<Claim> submitClaim(@RequestBody ClaimRequest claimRequest) {
        Claim createdClaim = claimService.createClaim(claimRequest);
        return new ResponseEntity<>(createdClaim, HttpStatus.CREATED);
    }
}
