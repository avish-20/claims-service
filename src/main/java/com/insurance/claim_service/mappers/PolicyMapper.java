package com.insurance.claim_service.mappers;

import org.mapstruct.Mapper;

import com.insurance.claim_service.dto.PolicyDto;
import com.insurance.claim_service.entity.Policy;

@Mapper(componentModel = "spring", uses = { PlanMapper.class })
public interface PolicyMapper {
    PolicyDto toDto(Policy policy);
    Policy toEntity(PolicyDto dto);
}