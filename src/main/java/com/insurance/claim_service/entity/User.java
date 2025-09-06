package com.insurance.claim_service.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDate;

import com.insurance.claim_service.BloodGroup;

@Entity
@Table(name = "users") // This must match your table name in the database
@Getter
@Setter
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Integer userId;

    private String name;

    private String email;

    @Column(name = "password_hash")
    private String passwordHash;

    @Column(name = "mobile_no")
    private String mobileNo;

    private LocalDate dob; // Spring Data JPA handles DATE to LocalDate mapping

    private String address;

    @Enumerated(EnumType.STRING)
    @Column(name = "blood_group")
    private BloodGroup bloodGroup;

    // We don't need created_at and updated_at for this test
}
