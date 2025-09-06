package com.insurance.claim_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.insurance.claim_service.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    // Spring Data JPA automatically provides methods like count(), save(),
    // findById(), etc.
}
