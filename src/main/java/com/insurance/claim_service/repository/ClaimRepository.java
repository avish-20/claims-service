package com.insurance.claim_service.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.insurance.claim_service.entity.Claim;
import com.insurance.claim_service.enums.ClaimStatus;

@Repository
public interface ClaimRepository extends JpaRepository<Claim, Integer> {
    List<Claim> findByClaimStatus(ClaimStatus claimStatus);
}
