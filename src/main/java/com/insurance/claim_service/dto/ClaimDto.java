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
public class ClaimDto {
    private Long id;
    private Double claimAmount;
    private String hospitalName;
    private String hospitalAddress;
    private LocalDate dateOfAdmission;
    private String healthIssue;
    private String category;
    private String documentsUrl;
    private String claimStatus;
    private String adminRemarks;
    private LocalDate submissionDate;
}
