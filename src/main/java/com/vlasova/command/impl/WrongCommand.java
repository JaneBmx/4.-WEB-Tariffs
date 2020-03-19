package com.vlasova.command.impl;

import com.vlasova.command.Command;
import com.vlasova.command.PageEnum;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class WrongCommand implements Command {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        return PageEnum.ERROR_PAGE.getValue();
    }
}
