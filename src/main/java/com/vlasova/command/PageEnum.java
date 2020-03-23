package com.vlasova.command;

public enum PageEnum {
    RESULT("/result.jsp"),
    ERROR("/error_page.jsp");

    private String path;

    PageEnum(String path) {
        this.path = path;
    }

    public String getValue() {
        return path;
    }
}
