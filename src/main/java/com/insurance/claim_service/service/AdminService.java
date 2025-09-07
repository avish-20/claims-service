package com.insurance.claim_service.service;

import java.util.List;

import com.insurance.claim_service.dto.ClaimDto;
import com.insurance.claim_service.dto.UserDto;

public interface AdminService {
    List<ClaimDto> getAllClaims();

    List<ClaimDto> getClaimsByStatus(String claimStatus); // Approved or Rejected

    UserDto findUserById(Integer userId);

    ClaimDto getClaimDetails(Integer claimId);

    ClaimDto updateClaimStatus(Integer claimId, String status, String adminRemarks);
}
