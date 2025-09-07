package com.insurance.claim_service.dto;

import java.time.LocalDate;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDto {
    private Integer id;
    private String name;
    private String email;
    private String mobileNo;
    private LocalDate dob;
    private String address;
    private String bloodGroup;
    private List<PolicyDto> policies;
}
