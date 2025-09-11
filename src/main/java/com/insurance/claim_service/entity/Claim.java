package com.insurance.claim_service.entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.insurance.claim_service.enums.ClaimStatus;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "claims")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@EntityListeners(AuditingEntityListener.class)
public class Claim {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    @Setter
    @Column(name = "claim_id")
    private Integer claimId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "policy_id", nullable = false)
    private Policy policy;

    @Column(name = "claim_amount", nullable = false)
    private Double  claimAmount;

    @Column(name = "hospital_name", nullable = false, length = 255)
    private String hospitalName;

    @Column(name = "hospital_address", length = 255)
    private String hospitalAddress;

    @Column(name = "date_of_admission", nullable = false)
    private LocalDate dateOfAdmission;

    @Column(name = "health_issue", nullable = false, length = 255)
    private String healthIssue;

    @Column(name = "category", length = 50)
    private String category;

    @Column(name = "documents_url", length = 255)
    private String documentsUrl;

    @Enumerated(EnumType.STRING)
    @Column(name = "claim_status", length = 20)
    private ClaimStatus claimStatus = ClaimStatus.PENDING;

    @Column(name = "assigned_level", length = 2)
    private String assignedLevel;

    @Column(name = "admin_remarks", length = 500)
    private String adminRemarks;

    @CreatedDate
    @Column(name = "submission_date", updatable = false)
    private LocalDateTime submissionDate;

    @LastModifiedDate
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;
}
