package com.insurance.claim_service.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.insurance.claim_service.dto.UserDto;
import com.insurance.claim_service.entity.User;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserDto toDto(User user);

    @Mapping(target = "id", ignore = true) // For new user creation
    User toEntity(UserDto dto);
}
