package com.vlasova.builder.sax;

import com.vlasova.entity.Billing;
import com.vlasova.entity.Tariff;
import com.vlasova.builder.TariffTag;
import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

import java.util.HashSet;
import java.util.Set;

public class TariffHandler extends DefaultHandler {
    private static final String TARIFF = "tariff";
    private Set<Tariff> tariffs = new HashSet<>();
    private Tariff current = null;
    private TariffTag currentTag = null;

    public Set<Tariff> getTariffs() {
        return tariffs;
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attrs) {
        if (TARIFF.equals(qName)) {
            current = new Tariff();
            current.setId(Integer.parseInt(attrs.getValue(0)));
        } else {
            String tagName = TariffTag.toEnumFormat(qName);
            currentTag = TariffTag.valueOf(tagName);
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) {
        if (TARIFF.equals(qName)) {
            tariffs.add(current);
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) {
        String string = new String(ch, start, length).trim();
        if (currentTag != null) {
            switch (currentTag) {
                case TARIFF_NAME:
                    current.setName(string);
                    break;
                case OPERATOR_NAME:
                    current.setOperatorName(string);
                    break;
                case PAYROLL:
                    current.setPayroll(Integer.parseInt(string));
                    break;
                case CALL_PRICE_INSIDE_THE_NETWORK:
                    current.getCallPrices().setInsideNetworkPrice(Integer.parseInt(string));
                    break;
                case CALL_PRICE_OUTSIDE_THE_NETWORK:
                    current.getCallPrices().setOutsideNetworkPrice(Integer.parseInt(string));
                    break;
                case CALL_PRICE_TO_STATIONARY_PHONE:
                    current.getCallPrices().setStationaryPhonePrice(Integer.parseInt(string));
                    break;
                case SMS_PRICE_INSIDE_THE_NETWORK:
                    current.getSmsPrice().setInsideNetworkPrice(Integer.parseInt(string));
                    break;
                case SMS_PRICE_OUTSIDE_THE_NETWORK:
                    current.getSmsPrice().setOutsideNetworkPrice(Integer.parseInt(string));
                    break;
                case NUMBER_OF_THE_FAVORITE_NUMBERS:
                    current.getParameters().setCountOfFavoriteNumbers(Integer.parseInt(string));
                    break;
                case BILLING:
                    current.getParameters().setBilling(Billing.valueOf(string.toUpperCase()));
                    break;
                case FEE_CONNECTION:
                    current.getParameters().setConnectionFee(Integer.parseInt(string));
                    break;
                default:
            }
        }
        currentTag = null;
    }
}