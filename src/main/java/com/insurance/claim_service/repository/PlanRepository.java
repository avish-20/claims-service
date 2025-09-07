package com.insurance.claim_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.insurance.claim_service.entity.Plan;

@Repository
public interface PlanRepository extends JpaRepository<Plan, Long> {
    // Example: List<Plan> findByActiveTrue();
}
