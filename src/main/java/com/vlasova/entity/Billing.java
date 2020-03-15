package com.vlasova.entity;

public enum Billing {
    MINUTE("60 seconds"),
    TWENTY_SECONDS("12 seconds");

    private String value;

    private Billing(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}