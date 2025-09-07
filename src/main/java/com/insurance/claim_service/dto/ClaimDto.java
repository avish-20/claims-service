package com.insurance.claim_service.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

import com.insurance.claim_service.enums.ClaimStatus;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class ClaimDto {
    private Integer claimId;
    private PolicyDto policy;
    private Double claimAmount;
    private String hospitalName;
    private String hospitalAddress;
    private LocalDate dateOfAdmission;
    private String healthIssue;
    private String category;
    private String documentsUrl;
    private ClaimStatus claimStatus;
    private String adminRemarks;
    private LocalDate submissionDate;
}
