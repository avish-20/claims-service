package com.insurance.claim_service.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.insurance.claim_service.entity.Claim;

@Repository
public interface ClaimRepository extends JpaRepository<Claim, Integer> {
    List<Claim> findByUserId(Long userId);
    List<Claim> findByClaimStatusIgnoreCase(String claimStatus);
}
