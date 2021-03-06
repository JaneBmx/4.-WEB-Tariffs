package com.vlasova.builder.sax;

import com.vlasova.builder.TariffsBuilder;
import org.apache.log4j.Logger;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;

import javax.xml.XMLConstants;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;

public class SAXTariffsBuilder extends TariffsBuilder {
    private static final Logger LOGGER = Logger.getLogger(SAXTariffsBuilder.class);
    private TariffHandler handler = new TariffHandler();
    private XMLReader reader;

    public SAXTariffsBuilder() {
        SAXParserFactory parserFactory = SAXParserFactory.newInstance();
        try {
            parserFactory.setFeature(XMLConstants.FEATURE_SECURE_PROCESSING, true);
            SAXParser parser = parserFactory.newSAXParser();
            reader = parser.getXMLReader();
            reader.setContentHandler(handler);
        } catch (SAXException e) {
            LOGGER.warn("SAX-parser exception");
        } catch (ParserConfigurationException e) {
            LOGGER.warn("Parser configuration exception");
        }
    }

    @Override
    public void buildTariffs(String fileName) {
        try {
            reader.parse(fileName);
        } catch (SAXException e) {
            LOGGER.warn("Exception with SAX-parser");
        } catch (IOException e) {
            LOGGER.warn("Exception while working with the resource");
        }
        tariffs = handler.getTariffs();
    }
}
