package com.insurance.claim_service.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.insurance.claim_service.dto.ClaimDto;
import com.insurance.claim_service.dto.UserDto;

public interface AdminService {
    List<ClaimDto> getAllClaims();
    
    ClaimDto getClaimDetails(Integer claimId);

    List<ClaimDto> getClaimsByStatus(String claimStatus); // Approved or Rejected

    UserDto findUserById(Integer userId);

    ClaimDto updateClaimStatus(Integer claimId, String status, String adminRemarks);

    Object categorizeClaim(Integer id);
}
