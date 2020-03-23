package com.vlasova.validator;

import org.apache.log4j.Logger;
import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

public class XMLValidator {
    private static final Logger LOGGER = Logger.getLogger(XMLValidator.class);
    private static final String SCHEMA_NAME = "src/main/resources/tariffs.xsd";

    public void validate(InputStream inputStream) {
        String language = XMLConstants.W3C_XML_SCHEMA_NS_URI;
        SchemaFactory factory = SchemaFactory.newInstance(language);
        ClassLoader classLoader = getClass().getClassLoader();
        try {
            File schemaLocation = new File(classLoader.getResource(SCHEMA_NAME).getFile());
            Schema schema = factory.newSchema(schemaLocation);
            Validator validator = schema.newValidator();
            validator.setFeature(XMLConstants.FEATURE_SECURE_PROCESSING, true);
            Source source = new StreamSource(inputStream);
            validator.validate(source);
        } catch (SAXException | IOException | NullPointerException e) {
            LOGGER.warn("File is nod valid");
        }
    }
}