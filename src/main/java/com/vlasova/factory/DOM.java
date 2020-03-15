package com.vlasova.factory;

import com.vlasova.entity.Tariff;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.util.List;

public class DOM implements Command {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String page;

        Part part = request.getPart("file");
        List<Tariff> list =









        return null;
    }
}
