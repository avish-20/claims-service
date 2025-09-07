package com.insurance.claim_service.mappers;

import org.mapstruct.Mapper;

import com.insurance.claim_service.dto.ClaimDto;
import com.insurance.claim_service.entity.Claim;

@Mapper(componentModel = "spring")
public interface ClaimMapper {
    ClaimDto toDto(Claim claim);
    Claim toEntity(ClaimDto dto);
}
