package com.insurance.claim_service.mappers;

import org.springframework.stereotype.Component;
import com.insurance.claim_service.dto.PlanDto;
import com.insurance.claim_service.entity.Plan;

@Component
public class PlanMapper {

    // Entity -> DTO
    public PlanDto toDto(Plan plan) {
        if (plan == null) return null;

        return PlanDto.builder()
                .id(plan.getPlanId())
                .planName(plan.getPlanName())
                .coverageAmount(plan.getCoverageAmount())
                .description(plan.getPlanDescription())
                .active(plan.getIsActive())
                .build();
    }

    // DTO -> Entity
    public Plan toEntity(PlanDto dto) {
        if (dto == null) return null;

        return Plan.builder()
                .planId(dto.getId())
                .planName(dto.getPlanName())
                .coverageAmount(dto.getCoverageAmount())
                .planDescription(dto.getDescription())
                .isActive(dto.getActive())
                .build();
    }
}