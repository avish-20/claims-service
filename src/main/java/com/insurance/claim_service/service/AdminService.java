package com.insurance.claim_service.service;

import java.util.List;

import com.insurance.claim_service.dto.ClaimDto;
import com.insurance.claim_service.dto.UserDto;

public interface AdminService {
    List<ClaimDto> getAllClaims();
    ClaimDto getClaimDetails(Long claimId);
    ClaimDto updateClaimStatus(Long claimId, String status, String remarks);
    UserDto findUser(Long userId);
}
