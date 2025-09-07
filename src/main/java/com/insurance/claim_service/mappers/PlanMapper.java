package com.insurance.claim_service.mappers;

import org.mapstruct.Mapper;

import com.insurance.claim_service.dto.PlanDto;
import com.insurance.claim_service.entity.Plan;

@Mapper(componentModel = "spring")
public interface PlanMapper {
    PlanDto toDto(Plan plan);
    Plan toEntity(PlanDto dto);
}
