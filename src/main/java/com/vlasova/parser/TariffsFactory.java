package com.vlasova.parser;

import com.vlasova.parser.dom.TariffsDOMBuilder;
import com.vlasova.parser.sax.TariffsSAXBuilder;
import com.vlasova.parser.stax.TariffsStAXBuilder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class TariffsFactory {
    private static final Logger LOGGER = LogManager.getLogger(TariffsFactory.class);

    public TariffsBuilder createTariffsBuilder(String typeParser) {
        String type = typeParser.toUpperCase();
        LOGGER.info("Preparing parser");
        switch (type) {
            case "DOM":
                return new TariffsDOMBuilder();
            case "SAX":
                return new TariffsSAXBuilder();
            case "STAX":
            default:
                LOGGER.info("Unknown parserType. Will be use default");
                return new TariffsStAXBuilder();
        }
    }
}