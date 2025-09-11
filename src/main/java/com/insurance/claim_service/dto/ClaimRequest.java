package com.insurance.claim_service.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ClaimRequest {

    private Integer policyId;
    private BigDecimal claimAmount;
    private String hospitalName;
    private String hospitalAddress;
    private LocalDate dateOfAdmission;
    private String healthIssue;
    private String category;
}
