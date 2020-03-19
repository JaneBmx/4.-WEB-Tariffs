package com.vlasova.command;

public enum JspParameter {
    COMMAND("command"),
    FILE("file"),
    RESULT("result"),
    ERROR("error");

    private String value;

    private JspParameter(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
