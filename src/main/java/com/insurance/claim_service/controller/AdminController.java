package com.insurance.claim_service.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.catalina.connector.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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

    @PostMapping("/claims/status")
    public ResponseEntity<?> getClaimsByStatus(@RequestBody Map<String, String> body) {
        String status = body.get("claim_status");
        try {
            return ResponseEntity.ok(adminService.getClaimsByStatus(status));
        } catch (IllegalArgumentException e) {
            // return proper error JSON if status is invalid
            Map<String, Object> errorResponse = new HashMap<>();
            errorResponse.put("error", "Invalid claim status");
            errorResponse.put("message", e.getMessage());
            return ResponseEntity.badRequest().body(errorResponse);
        } catch (Exception e) {
            // fallback for unexpected errors
            Map<String, Object> errorResponse = new HashMap<>();
            errorResponse.put("error", "Something went wrong");
            errorResponse.put("message", e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse);
        }
    }

    @PostMapping("/claims/update")
    public ResponseEntity<ClaimDto> updateClaimStatus(@RequestBody Map<String, String> body) {
        Integer id = Integer.valueOf(body.get("claim_id"));
        String status = body.get("claim_status");
        String remarks = body.get("remarks");
        return ResponseEntity.ok(adminService.updateClaimStatus(id, status, remarks));
    }

    @PostMapping("/claims/catgorize/{claim_id}")
    public ResponseEntity<Object> categorizeClaim(@PathVariable Integer claim_id) {
        return ResponseEntity.ok(adminService.categorizeClaim(claim_id));
    }

    @GetMapping("/users/{userId}")
    public ResponseEntity<UserDto> findUser(@PathVariable Integer userId) {
        return ResponseEntity.ok(adminService.findUserById(userId));
    }
}
