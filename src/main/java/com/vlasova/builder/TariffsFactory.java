package com.vlasova.builder;

import com.vlasova.builder.dom.DOMTariffsBuilder;
import com.vlasova.builder.sax.SAXTariffsBuilder;
import com.vlasova.builder.stax.StAXTariffsBuilder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class TariffsFactory {
    private static final Logger LOGGER = LogManager.getLogger(TariffsFactory.class);

    public TariffsBuilder createTariffsBuilder(String typeParser) {
        String type = typeParser.toUpperCase();
        LOGGER.info("Preparing parser");
        switch (type) {
            case "DOM":
                return new DOMTariffsBuilder();
            case "SAX":
                return new SAXTariffsBuilder();
            case "STAX":
            default:
                LOGGER.info("Unknown parserType. Will be use default");
                return new StAXTariffsBuilder();
        }
    }
}