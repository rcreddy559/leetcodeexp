package com.utils;

// Using an enum class (preferred approach for modern Java)
public enum Department {
    SALES("Sales Department", "S"),
    MARKETING("Marketing Department", "M"),
    ENGINEERING("Engineering Department", "E"),
    HUMAN_RESOURCES("Human Resources Department", "HR"),
    FINANCE("Finance Department", "F");

    private final String fullName;
    private final String shortCode;

    Department(String fullName, String shortCode) {
        this.fullName = fullName;
        this.shortCode = shortCode;
    }

    public String getFullName() {
        return fullName;
    }

    public String getShortCode() {
        return shortCode;
    }

}