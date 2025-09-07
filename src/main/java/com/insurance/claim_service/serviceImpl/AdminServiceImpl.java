package com.insurance.claim_service.serviceImpl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.insurance.claim_service.dto.ClaimDto;
import com.insurance.claim_service.dto.UserDto;
import com.insurance.claim_service.service.AdminService;

@Service
public class AdminServiceImpl implements AdminService{

    @Override
    public List<ClaimDto> getAllClaims() {
        return null;
    }

    @Override
    public ClaimDto getClaimDetails(Integer claimId) {
        return null;
    }

    @Override
    public ClaimDto updateClaimStatus(Integer claimId, String status, String remarks) {
        return null;
    }

    @Override
    public UserDto findUserById(Integer userId) {
        return null;
    }

    @Override
    public List<ClaimDto> getClaimsByStatus(String claimStatus) {
        return null;
    }

}
