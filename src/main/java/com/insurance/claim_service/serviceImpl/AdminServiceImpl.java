package com.insurance.claim_service.serviceImpl;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.insurance.claim_service.dto.ClaimDto;
import com.insurance.claim_service.dto.UserDto;
import com.insurance.claim_service.entity.Claim;
import com.insurance.claim_service.enums.ClaimStatus;
import com.insurance.claim_service.mappers.*;
import com.insurance.claim_service.repository.ClaimRepository;
import com.insurance.claim_service.repository.UserRepository;
import com.insurance.claim_service.service.AdminService;

import jakarta.transaction.Transactional;

@Service
public class AdminServiceImpl implements AdminService {
        @Autowired
        private ClaimRepository claimRepository;
        @Autowired
        private UserRepository userRepository;
        @Autowired
        private ClaimMapper claimMapper;
        @Autowired
        private UserMapper userMapper;

        @Override
        public List<ClaimDto> getAllClaims() {
                return claimRepository.findAll()
                                .stream()
                                .map(claimMapper::toDto)
                                .toList();
        }

        @Override
        public ClaimDto getClaimDetails(Integer claimId) {
                Claim claim = claimRepository.findById(claimId)
                                .orElseThrow(() -> new ResponseStatusException(
                                                HttpStatus.NOT_FOUND, "Claim not found with ID: " + claimId));

                return claimMapper.toDto(claim);
        }

        @Transactional
        @Override
        public ClaimDto updateClaimStatus(Integer claimId, String status, String remarks) {
                Claim claim = claimRepository.findById(claimId)
                                .orElseThrow(() -> new RuntimeException("Claim not found with id: " + claimId));

                ClaimStatus matchedStatus = Arrays.stream(ClaimStatus.values())
                                .filter(cs -> cs.name().equalsIgnoreCase(status))
                                .findFirst()
                                .orElseThrow(() -> new IllegalArgumentException(
                                                "Invalid claim status: " + status +
                                                                ". Allowed values (case-insensitive): "
                                                                + Arrays.toString(ClaimStatus.values())));

                claim.setClaimStatus(matchedStatus);
                claim.setAdminRemarks(remarks);
                return claimMapper.toDto(claimRepository.save(claim));
        }

        @Override
        public UserDto findUserById(Integer userId) {
                return userRepository.findById(userId)
                                .map(userMapper::toDto)
                                .orElseThrow(() -> new RuntimeException("User not found with id: " + userId));
        }

        @Override
        public List<ClaimDto> getClaimsByStatus(String claimStatus) {
                ClaimStatus matchedStatus = Arrays.stream(ClaimStatus.values())
                                .filter(cs -> cs.name().equalsIgnoreCase(claimStatus))
                                .findFirst()
                                .orElseThrow(() -> new IllegalArgumentException(
                                                "Invalid claim status: " + claimStatus +
                                                                ". Allowed values: "
                                                                + Arrays.toString(ClaimStatus.values())));
                // Fetch claims by status
                List<Claim> claims = claimRepository.findByClaimStatus(matchedStatus);

                // Convert to DTOs
                return claims.stream()
                                .map(claimMapper::toDto)
                                .collect(Collectors.toList());

        }

        @Override
        public Object categorizeClaim(Integer id) {
                return null;
        }

}
