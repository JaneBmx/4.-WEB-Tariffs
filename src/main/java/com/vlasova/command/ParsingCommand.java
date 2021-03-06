package com.vlasova.command;

import com.vlasova.entity.Tariff;
import com.vlasova.builder.TariffsBuilder;
import com.vlasova.factory.CommandFactory;
import com.vlasova.validator.XMLValidator;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.util.List;

public class ParsingCommand {
    private static final Logger LOGGER = Logger.getLogger(ParsingCommand.class);
    private static final String PARSER = "parser";
    private static final String FILE = "file";

    public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String page;
        try {
            Part part = request.getPart(FILE);
            String formedPath = formPath(request, part);

            CommandFactory factory = new CommandFactory();
            TariffsBuilder builder = factory.createCommand(request.getParameter(PARSER));
            builder.buildTariffs(formedPath);

            List<Tariff> list = builder.getTariffs();
            request.setAttribute("list", list);
            page = PageEnum.RESULT.getValue();
        } catch (Exception e) {
            LOGGER.warn("Smth went wrong with parser.");
            page = PageEnum.ERROR.getValue();
        }
        return page;
    }

    private String formPath(HttpServletRequest request, Part part) throws IOException {
        String appPath = request.getServletContext().getRealPath("");
        String formedPath = null;
        if (part.getSubmittedFileName() != null) {
            formedPath = appPath + File.separator + part.getSubmittedFileName();
            part.write(formedPath);
        } else {
            LOGGER.error("No xml file");
        }
        return formedPath;
    }

    private void validate(String formedPath) throws FileNotFoundException {
        FileInputStream formedPathStream = new FileInputStream(formedPath);
        XMLValidator validator = new XMLValidator();
        validator.validate(formedPathStream);
    }
}