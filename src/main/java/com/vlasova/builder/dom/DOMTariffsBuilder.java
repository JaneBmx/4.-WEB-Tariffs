package com.vlasova.builder.dom;

import com.vlasova.entity.Billing;
import com.vlasova.entity.Tariff;
import com.vlasova.builder.TariffTag;
import com.vlasova.builder.TariffsBuilder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public class DOMTariffsBuilder extends TariffsBuilder {
    private static final Logger LOGGER = LogManager.getLogger(DOMTariffsBuilder.class);
    private DocumentBuilder docBuilder;

    public DOMTariffsBuilder() {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        try {
            factory.setFeature(XMLConstants.FEATURE_SECURE_PROCESSING, true);
            docBuilder = factory.newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            LOGGER.warn("Parser configuration error");
        }
    }

    @Override
    public void buildTariffs(String fileName) {
        Document document;
        try {
            document = docBuilder.parse(fileName);
            Element root = document.getDocumentElement();

            NodeList tariffsList = root.getElementsByTagName("tariff");
            for (int i = 0; i < tariffsList.getLength(); i++) {
                Element tariffElement = (Element) tariffsList.item(i);
                Tariff tariff = buildTariff(tariffElement);
                tariffs.add(tariff);
            }
        } catch (IOException e) {
            LOGGER.warn("File error or IO error", e);
        } catch (SAXException e) {
            LOGGER.warn("Parsing failure", e);
        }
    }

    private Tariff buildTariff(Element tariffElement) {
        Tariff tariff = new Tariff();
        int id = Integer.parseInt(tariffElement.getAttribute(TariffTag.ID.toTag()));
        String tariffName = getElementTextContext(tariffElement, TariffTag.TARIFF_NAME.toTag());
        String operatorName = getElementTextContext(tariffElement, TariffTag.OPERATOR_NAME.toTag());
        int payroll = Integer.parseInt(getElementTextContext(tariffElement, TariffTag.PAYROLL.toTag()));

        Element callPricesElement = (Element) tariffElement.getElementsByTagName(TariffTag.CALL_PRICES.toTag()).item(0);
        int callInTheNet = Integer.parseInt(getElementTextContext(callPricesElement, TariffTag.CALL_PRICE_INSIDE_THE_NETWORK.toTag()));
        int callOutTheNet = Integer.parseInt(getElementTextContext(callPricesElement, TariffTag.CALL_PRICE_OUTSIDE_THE_NETWORK.toTag()));
        int callToStationary = Integer.parseInt(getElementTextContext(callPricesElement, TariffTag.CALL_PRICE_TO_STATIONARY_PHONE.toTag()));

        Element smsPricesElement = (Element) tariffElement.getElementsByTagName(TariffTag.SMS_PRICES.toTag()).item(0);
        int smsInTheNet = Integer.parseInt(getElementTextContext(smsPricesElement, TariffTag.SMS_PRICE_INSIDE_THE_NETWORK.toTag()));
        int smsOutTheNet = Integer.parseInt(getElementTextContext(smsPricesElement, TariffTag.SMS_PRICE_OUTSIDE_THE_NETWORK.toTag()));

        Element parametersElement = (Element) tariffElement.getElementsByTagName(TariffTag.PARAMETERS.toTag()).item(0);
        int favoriteNum = Integer.parseInt(getElementTextContext(parametersElement, TariffTag.NUMBER_OF_THE_FAVORITE_NUMBERS.toTag()));
        Billing billing = Billing.valueOf(
                getElementTextContext(parametersElement, TariffTag.BILLING.toTag())
                        .toUpperCase());
        int feeConnection = Integer.parseInt(getElementTextContext(parametersElement, TariffTag.FEE_CONNECTION.toTag()));

        tariff.setId(id);
        tariff.setName(tariffName);
        tariff.setOperatorName(operatorName);
        tariff.setPayroll(payroll);
        tariff.getCallPrices().setInsideNetworkPrice(callInTheNet);
        tariff.getCallPrices().setOutsideNetworkPrice(callOutTheNet);
        tariff.getCallPrices().setStationaryPhonePrice(callToStationary);
        tariff.getSmsPrice().setInsideNetworkPrice(smsInTheNet);
        tariff.getSmsPrice().setOutsideNetworkPrice(smsOutTheNet);
        tariff.getParameters().setCountOfFavoriteNumbers(favoriteNum);
        tariff.getParameters().setBilling(billing);
        tariff.getParameters().setConnectionFee(feeConnection);
        return tariff;
    }

    private static String getElementTextContext(Element element, String elementName) {
        NodeList nodeList = element.getElementsByTagName(elementName);
        Node node = nodeList.item(0);
        return node.getTextContent();
    }
}