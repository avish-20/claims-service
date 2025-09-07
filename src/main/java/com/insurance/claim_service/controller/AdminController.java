package com.insurance.claim_service.controller;

import java.util.List;

import org.apache.catalina.connector.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.insurance.claim_service.dto.ClaimDto;
import com.insurance.claim_service.dto.UserDto;
import com.insurance.claim_service.service.AdminService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/claimService/admin")
@RequiredArgsConstructor
public class AdminController {
    private final AdminService adminService;

    @GetMapping("/claims")
    public ResponseEntity<List<ClaimDto>> getAllClaims() {
        return ResponseEntity.ok(adminService.getAllClaims());
    }

    @GetMapping("/claims/{claimId}")
    public ResponseEntity<ClaimDto> getClaimDetails(@PathVariable Integer claimId) {
        return ResponseEntity.ok(adminService.getClaimDetails(claimId));
    }

    @GetMapping("/claims/status/{status}")
    public ResponseEntity<List<ClaimDto>> getClaimsByStatus(@PathVariable String status) {
        return ResponseEntity.ok(adminService.getClaimsByStatus(status));
    }

    @PutMapping("/claims/{id}/status")
    public ResponseEntity<ClaimDto> updateClaimStatus(@PathVariable Integer id, @RequestParam String status,
            @RequestParam(required = false) String remarks) {
        return ResponseEntity.ok(adminService.updateClaimStatus(id, status, remarks));
    }

    @GetMapping("/users/{userId}")
    public ResponseEntity<UserDto> findUser(@PathVariable Integer userId) {
        return ResponseEntity.ok(adminService.findUserById(userId));
    }
}
