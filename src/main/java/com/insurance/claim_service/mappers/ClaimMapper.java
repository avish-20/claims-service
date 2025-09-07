package com.insurance.claim_service.mappers;

import com.insurance.claim_service.dto.ClaimDto;
import com.insurance.claim_service.dto.PolicyDto;
import com.insurance.claim_service.entity.Claim;
import com.insurance.claim_service.entity.Policy;
import org.springframework.stereotype.Component;

@Component
public class ClaimMapper {

    // Convert Entity -> DTO
    public ClaimDto toDto(Claim claim) {
        if (claim == null) {
            return null;
        }

        return ClaimDto.builder()
                .claimId(claim.getClaimId())
                .policy(toPolicyDto(claim.getPolicy()))   // nested mapping
                .claimAmount(claim.getClaimAmount())      // BigDecimal directly
                .hospitalName(claim.getHospitalName())
                .hospitalAddress(claim.getHospitalAddress())
                .dateOfAdmission(claim.getDateOfAdmission())
                .healthIssue(claim.getHealthIssue())
                .category(claim.getCategory())
                .documentsUrl(claim.getDocumentsUrl())
                .claimStatus(claim.getClaimStatus())
                .adminRemarks(claim.getAdminRemarks())
                .submissionDate(claim.getSubmissionDate() != null ? claim.getSubmissionDate().toLocalDate() : null)
                .build();
    }

    // Convert DTO -> Entity
    public Claim toEntity(ClaimDto dto) {
        if (dto == null) {
            return null;
        }

        return Claim.builder()
                .claimId(dto.getClaimId())
                .policy(toPolicyEntity(dto.getPolicy()))
                .claimAmount(dto.getClaimAmount())        // BigDecimal directly
                .hospitalName(dto.getHospitalName())
                .hospitalAddress(dto.getHospitalAddress())
                .dateOfAdmission(dto.getDateOfAdmission())
                .healthIssue(dto.getHealthIssue())
                .category(dto.getCategory())
                .documentsUrl(dto.getDocumentsUrl())
                .claimStatus(dto.getClaimStatus())
                .adminRemarks(dto.getAdminRemarks())
                // submissionDate & updatedAt handled by auditing → don’t set manually
                .build();
    }

    // Policy → PolicyDto mapping
    private PolicyDto toPolicyDto(Policy policy) {
        if (policy == null) {
            return null;
        }
        return PolicyDto.builder()
                .policyId(policy.getPolicyId())
                .policyNumber(policy.getPolicyNumber())
                .startDate(policy.getStartDate())
                .endDate(policy.getEndDate())
                .premiumAmount(policy.getPremiumAmount())
                .build();
    }

    // PolicyDto → Policy mapping
    private Policy toPolicyEntity(PolicyDto dto) {
        if (dto == null) {
            return null;
        }
        return Policy.builder()
                .policyId(dto.getPolicyId())
                .policyNumber(dto.getPolicyNumber())
                .startDate(dto.getStartDate())
                .endDate(dto.getEndDate())
                .premiumAmount(dto.getPremiumAmount())
                .build();
    }
}