package com.insurance.claim_service.mappers;

import org.springframework.stereotype.Component;
import com.insurance.claim_service.dto.PolicyDto;
import com.insurance.claim_service.entity.Policy;
import com.insurance.claim_service.enums.PolicyStatus;

@Component
public class PolicyMapper {

    private final PlanMapper planMapper;

    // Constructor Injection for PlanMapper
    public PolicyMapper(PlanMapper planMapper) {
        this.planMapper = planMapper;
    }

    // Entity -> DTO
    public PolicyDto toDto(Policy policy) {
        if (policy == null) {
            return null;
        }

        return PolicyDto.builder()
                .policyId(policy.getPolicyId())
                .policyNumber(policy.getPolicyNumber())
                .premiumAmount(policy.getPremiumAmount())
                .startDate(policy.getStartDate())
                .endDate(policy.getEndDate())
                .status(policy.getStatus() != null ? policy.getStatus().name() : null)
                .plan(planMapper.toDto(policy.getPlan())) // nested Plan mapping
                .build();
    }

    // DTO -> Entity
    public Policy toEntity(PolicyDto dto) {
        if (dto == null) {
            return null;
        }

        return Policy.builder()
                .policyId(dto.getPolicyId())
                .policyNumber(dto.getPolicyNumber())
                .premiumAmount(dto.getPremiumAmount())
                .startDate(dto.getStartDate())
                .endDate(dto.getEndDate())
                .status(dto.getStatus() != null ? PolicyStatus.valueOf(dto.getStatus()) : null)
                .plan(planMapper.toEntity(dto.getPlan())) // nested Plan mapping
                .build();
    }
}