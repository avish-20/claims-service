package com.insurance.claim_service.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PlanDto {
    private Long id;
    private String planName;
    private Double coverageAmount;
    private String description;
    private Boolean active;
}
