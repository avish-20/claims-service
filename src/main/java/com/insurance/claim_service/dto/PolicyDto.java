package com.insurance.claim_service.dto;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PolicyDto {
    private Long id;
    private String policyNumber;
    private Double premiumAmount;
    private LocalDate startDate;
    private LocalDate endDate;
    private String status;
    private PlanDto plan;
}
