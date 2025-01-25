package com.poundwise.customer;

public record CustomerRegistrationRequest(
        String firstName, String lastName, String email) {
}
