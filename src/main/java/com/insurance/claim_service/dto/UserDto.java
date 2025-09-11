package com.insurance.claim_service.dto;

import java.time.LocalDate;
import java.util.List;

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
