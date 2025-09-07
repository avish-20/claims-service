package com.insurance.claim_service.dto;

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
public class PlanDto {
    private Integer id;
    private String planName;
    private Double coverageAmount;
    private String description;
    private Boolean active;
}
