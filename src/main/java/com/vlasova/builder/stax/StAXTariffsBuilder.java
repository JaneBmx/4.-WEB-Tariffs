package com.vlasova.builder.stax;

import com.vlasova.builder.TariffTag;
import com.vlasova.entity.*;
import com.vlasova.builder.TariffsBuilder;
//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class StAXTariffsBuilder extends TariffsBuilder {
   // private static final Logger LOGGER = LogManager.getLogger(StAXTariffsBuilder.class);
    private static final String TARIFF = "tariff";
    private XMLInputFactory inputFactory = XMLInputFactory.newInstance();

    @Override
    public void buildTariffs(String fileName) {
        XMLStreamReader reader;
        String name;
        try (FileInputStream inputStream = new FileInputStream(fileName)) {
            reader = inputFactory.createXMLStreamReader(inputStream);
            int type;
            while (reader.hasNext()) {
                type = reader.next();
                if (type == XMLStreamConstants.START_ELEMENT) {
                    name = reader.getLocalName();
                    if (TARIFF.equals(name)) {
                        Tariff tariff = buildTariff(reader);
                        tariffs.add(tariff);
                    }
                }
            }
        } catch (XMLStreamException e) {
           // LOGGER.warn("StAX parser exception");
        } catch (FileNotFoundException e) {
           // LOGGER.warn("File not found");
        } catch (IOException e) {
           // LOGGER.warn("IO exception");
        }
    }

    private Tariff buildTariff(XMLStreamReader reader) throws XMLStreamException {
        Tariff currentTariff = new Tariff();
        currentTariff.setId(Integer.parseInt(reader.getAttributeValue(null, TariffTag.ID.toTag())));
        String name;
        int type;
        while (reader.hasNext()) {
            type = reader.next();
            if (type == XMLStreamConstants.START_ELEMENT) {
                name = reader.getLocalName();
                switch (TariffTag.valueOf(TariffTag.toEnumFormat(name))) {
                    case TARIFF_NAME:
                        currentTariff.setName(getXMLText(reader));
                        break;
                    case OPERATOR_NAME:
                        currentTariff.setOperatorName(getXMLText(reader));
                        break;
                    case PAYROLL:
                        currentTariff.setPayroll(Integer.parseInt(getXMLText(reader)));
                        break;
                    case CALL_PRICES:
                        currentTariff.setCallPrices(getXMLCallPrices(reader));
                        break;
                    case SMS_PRICES:
                        currentTariff.setSmsPrice(getXMLSmsPrices(reader));
                        break;
                    case PARAMETERS:
                        currentTariff.setParameters(getXMLParameters(reader));
                        break;
                    default:
                }
            }
            if (type == XMLStreamConstants.END_ELEMENT) {
                name = reader.getLocalName();
                if (TARIFF.equals(name)) {
                    return currentTariff;
                }
            }
        }
       // LOGGER.warn("Unknown element in tag tariff");
        throw new XMLStreamException("Unknown element in tag tariff");
    }


    private String getXMLText(XMLStreamReader reader) throws XMLStreamException {
        String text = null;
        if (reader.hasNext()) {
            reader.next();
            text = reader.getText();
        }
        return text;
    }

    private CallPrices getXMLCallPrices(XMLStreamReader reader) throws XMLStreamException {
        CallPrices callPrices = new CallPrices();
        int type;
        String name;
        while (reader.hasNext()) {
            type = reader.next();
            if (type == XMLStreamConstants.START_ELEMENT) {
                name = reader.getLocalName();
                switch (TariffTag.valueOf(TariffTag.toEnumFormat(name))) {
                    case CALL_PRICE_INSIDE_THE_NETWORK:
                        callPrices.setInsideNetworkPrice(Integer.parseInt(getXMLText(reader)));
                        break;
                    case CALL_PRICE_OUTSIDE_THE_NETWORK:
                        callPrices.setOutsideNetworkPrice(Integer.parseInt(getXMLText(reader)));
                        break;
                    case CALL_PRICE_TO_STATIONARY_PHONE:
                        callPrices.setStationaryPhonePrice(Integer.parseInt(getXMLText(reader)));
                        break;
                    default:
                }
            }
            if (type == XMLStreamConstants.END_ELEMENT) {
                name = reader.getLocalName();
                if (TariffTag.valueOf(TariffTag.toEnumFormat(name)) == TariffTag.CALL_PRICES) {
                    return callPrices;
                }
            }
        }
       // LOGGER.warn("Unknown element in tag callPrices.");
        throw new XMLStreamException("Unknown element in tag callPrices.");
    }

    private SmsPrice getXMLSmsPrices(XMLStreamReader reader) throws XMLStreamException {
        SmsPrice smsPrices = new SmsPrice();
        int type;
        String name;
        while (reader.hasNext()) {
            type = reader.next();
            switch (type) {
                case XMLStreamConstants.START_ELEMENT:
                    name = reader.getLocalName();
                    switch (TariffTag.valueOf(TariffTag.toEnumFormat(name))) {
                        case SMS_PRICE_INSIDE_THE_NETWORK:
                            smsPrices.setInsideNetworkPrice(Integer.parseInt(getXMLText(reader)));
                            break;
                        case SMS_PRICE_OUTSIDE_THE_NETWORK:
                            smsPrices.setOutsideNetworkPrice(Integer.parseInt(getXMLText(reader)));
                            break;
                        default:
                    }
                    break;
                case XMLStreamConstants.END_ELEMENT:
                    name = reader.getLocalName();
                    if (TariffTag.valueOf(TariffTag.toEnumFormat(name)) == TariffTag.SMS_PRICES) {
                        return smsPrices;
                    }
                    break;
                default:
            }
        }
       // LOGGER.warn("Unknown element in tag smsPrices.");
        throw new XMLStreamException("Unknown element in tag smsPrices.");
    }

    private Parameters getXMLParameters(XMLStreamReader reader) throws XMLStreamException {
        Parameters parameters = new Parameters();
        int type;
        String name;
        while (reader.hasNext()) {
            type = reader.next();
            if (type == XMLStreamConstants.START_ELEMENT) {
                name = reader.getLocalName();
                switch (TariffTag.valueOf(TariffTag.toEnumFormat(name))) {
                    case NUMBER_OF_THE_FAVORITE_NUMBERS:
                        parameters.setCountOfFavoriteNumbers(Integer.parseInt(getXMLText(reader)));
                        break;
                    case BILLING:
                        name = getXMLText(reader);
                        name = name == null ? "" : name.toUpperCase();
                        parameters.setBilling(Billing.valueOf(name));
                        break;
                    case FEE_CONNECTION:
                        parameters.setConnectionFee(Integer.parseInt(getXMLText(reader)));
                        break;
                    default:
                }
            }
            if (type == XMLStreamConstants.END_ELEMENT) {
                name = reader.getLocalName();
                if (TariffTag.valueOf(TariffTag.toEnumFormat(name)) == TariffTag.PARAMETERS) {
                    return parameters;
                }
            }
        }
       // LOGGER.warn("Unknown element in tag parameters.");
        throw new XMLStreamException("Unknown element in tag parameters.");
    }
}