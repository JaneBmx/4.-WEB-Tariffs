package com.vlasova.command;

public enum PageEnum {
    WELCOME_PAGE("/index.jsp"),
    RESULT_PAGE("/result.jsp"),
    ERROR_PAGE("/error_page.jsp");

    private String path;

    PageEnum(String path) {
        this.path = path;
    }

    public String getPath(){
        return path;
    }
}
