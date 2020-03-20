package com.vlasova.factory;

import com.vlasova.builder.TariffsBuilder;
import com.vlasova.builder.dom.DOMTariffsBuilder;
import com.vlasova.builder.sax.SAXTariffsBuilder;
import com.vlasova.builder.stax.StAXTariffsBuilder;
//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;

public class CommandFactory {
    //private static final Logger LOGGER = LogManager.getLogger(CommandFactory.class);

    public TariffsBuilder createCommand(String typeParser) {
        String type = typeParser.toUpperCase();
        switch (type) {
            case "DOM":
                return new DOMTariffsBuilder();
            case "SAX":
                return new SAXTariffsBuilder();
            case "STAX":
                return new StAXTariffsBuilder();
            default:
                //LOGGER.info("Unknown parserType. Will be used default");
                return new DOMTariffsBuilder();
        }
    }
}