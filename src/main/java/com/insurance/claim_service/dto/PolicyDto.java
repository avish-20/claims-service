package com.insurance.claim_service.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class PolicyDto {
    private Integer policyId;
    private String policyNumber;
    private Double premiumAmount;
    private LocalDate startDate;
    private LocalDate endDate;
    private String status;
    private PlanDto plan;
}
