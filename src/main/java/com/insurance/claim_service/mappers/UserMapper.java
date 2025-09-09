package com.insurance.claim_service.mappers;

import com.insurance.claim_service.dto.UserDto;
import com.insurance.claim_service.entity.User;
import com.insurance.claim_service.enums.BloodGroup;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class UserMapper {

    private final PolicyMapper policyMapper;

    public UserMapper(PolicyMapper policyMapper) {
        this.policyMapper = policyMapper;
    }

    // Entity -> DTO
    public UserDto toDto(User user) {
        if (user == null) {
            return null;
        }

        return UserDto.builder()
                .id(user.getUserId())
                .name(user.getName())
                .email(user.getEmail())
                .mobileNo(user.getMobileNo())
                .dob(user.getDob())
                .address(user.getAddress())
                .bloodGroup(user.getBloodGroup() != null ? user.getBloodGroup().toString() : null) // Enum -> String
                .policies(user.getPolicies() != null
                        ? user.getPolicies().stream().map(policyMapper::toDto).collect(Collectors.toList())
                        : null)
                .build();
    }

    // DTO -> Entity
    public User toEntity(UserDto dto) {
        if (dto == null) {
            return null;
        }

        return User.builder()
                .userId(dto.getId())
                .name(dto.getName())
                .email(dto.getEmail())
                .mobileNo(dto.getMobileNo())
                .dob(dto.getDob())
                .address(dto.getAddress())
                .bloodGroup(dto.getBloodGroup() != null ? fromString(dto.getBloodGroup()) : null) // String -> Enum
                .policies(dto.getPolicies() != null
                        ? dto.getPolicies().stream().map(policyMapper::toEntity).collect(Collectors.toList())
                        : null)
                .build();
    }

    // Helper: Convert string (like "A+") to BloodGroup enum
    private BloodGroup fromString(String value) {
        for (BloodGroup bg : BloodGroup.values()) {
            if (bg.toString().equalsIgnoreCase(value)) {
                return bg;
            }
        }
        throw new IllegalArgumentException("Invalid blood group: " + value);
    }
}