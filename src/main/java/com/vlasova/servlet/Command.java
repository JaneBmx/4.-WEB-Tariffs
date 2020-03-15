package com.vlasova.servlet;

import com.vlasova.entity.Tariff;
import com.vlasova.parser.TariffsBuilder;
import com.vlasova.parser.TariffsFactory;
import com.vlasova.validator.XMLValidator;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Command {
    private static final String SAX = "SAX";
    private static final String DOM = "DOM";
    private static final String STAX = "STAX";
    private static final String PARSER_NAME = "parser";
    private static final String FILE_PATH = "file";
   // private Part part;

    public String execute(HttpServletRequest request) throws IOException, ServletException {
        String resultPage = "/result.jsp";
        //String parser = request.getParameter(PARSER_NAME).toUpperCase();
        String parser = "DOM";
        //TODO validation

        TariffsFactory factory = new TariffsFactory();
        TariffsBuilder builder = factory.createTariffsBuilder(parser);
        // builder.buildTariffs(request.getParameter(FILE_PATH));
        builder.buildTariffs("src/main/resources/tariffs.xml");

        Set<Tariff> tariffs = builder.getTariffs();
        List<Tariff> list = new ArrayList<>(tariffs);
        request.setAttribute("list", list);
        return resultPage;
    }

//    private String formPath(HttpServletRequest request) throws IOException, ServletException {
//        String appPath = request.getServletContext().getRealPath("");
//        String formedPath = null;
//        part = request.getPart(FILE_PATH);
//        if (part.getSubmittedFileName() != null) {
//            formedPath = appPath + File.separator + part.getSubmittedFileName();
//            part.write(formedPath);
//        } else {
//            //TODO logger
//        }
//        return formedPath;
//    }
//
//    private void validateFile(String formedPath) throws IOException {
//        FileInputStream formedPathStream = new FileInputStream(formedPath);
//        XMLValidator validator = new XMLValidator();
//        validator.validate(formedPathStream);
//    }
}