package com.insurance.claim_service;

public enum BloodGroup {
    A_POS("A+"),
    A_NEG("A-"),
    B_POS("B+"),
    B_NEG("B-"),
    AB_POS("AB+"),
    AB_NEG("AB-"),
    O_POS("O+"),
    O_NEG("O-");

    private final String value;

    BloodGroup(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}
