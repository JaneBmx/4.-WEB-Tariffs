package com.vlasova.command.redundant;

import com.vlasova.command.PageEnum;
import com.vlasova.entity.Tariff;
import com.vlasova.builder.TariffsBuilder;
import com.vlasova.factory.TariffsFactory;
import com.vlasova.validator.XMLValidator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import javax.servlet.http.Part;
import java.util.List;

public class ParsingCommand {
    private static final Logger LOGGER = LogManager.getLogger(ParsingCommand.class);
    private static final String SAX = "SAX";
    private static final String DOM = "DOM";
    private static final String STAX = "STAX";
    private static final String PARAM_NAME_PARSER = "parser";
    private static final String PARAM_NAME_FILE = "file";
    private Part part;

    public String execute(HttpServletRequest request) throws IOException, ServletException {
        String page = PageEnum.RESULT_PAGE.getValue();
        String parser = request.getParameter(PARAM_NAME_PARSER).toUpperCase();
        boolean check = parser.equalsIgnoreCase(SAX) || parser.equalsIgnoreCase(DOM) || parser.equalsIgnoreCase(STAX);
        if (check) {
            String formedPath = formPath(request);
            validateFile(formedPath);

            TariffsFactory tariffsBuilderFactory = new TariffsFactory();
            TariffsBuilder builder = tariffsBuilderFactory.createTariffsBuilder(parser);
            builder.buildTariffs(formedPath);
            //TODO qwe

            List<Tariff> list = builder.getTariffs();
            request.setAttribute("list", list);
        } else {
            LOGGER.warn("Incorrect parser name");
            page = PageEnum.ERROR_PAGE.getValue();
        }
        return page;
    }

    private String formPath(HttpServletRequest request) throws IOException, ServletException {
        String appPath = request.getServletContext().getRealPath("");
        String formedPath = null;
        part = request.getPart(PARAM_NAME_FILE);
        if (part.getSubmittedFileName() != null) {
            formedPath = appPath + File.separator + part.getSubmittedFileName();
            part.write(formedPath);
        } else {
            LOGGER.error("No xml file");
        }
        return formedPath;
    }

    private void validateFile(String formedPath) throws IOException {
        FileInputStream formedPathStream = new FileInputStream(formedPath);
        XMLValidator validator = new XMLValidator();
        validator.validate(formedPathStream);
    }
}