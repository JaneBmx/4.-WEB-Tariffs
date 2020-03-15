package com.vlasova.parser;

import com.vlasova.entity.*;

public class TariffsBuilderTestData {
    public static final String FILE_NAME = "src/test/resources/testTariff.xml";
    public static final Tariff TARIFF = new Tariff(
            1, "Bezlimitishe", "MTS", 999,
            new CallPrices(1, 2, 3),
            new SmsPrice(4, 5),
            new Parameters(6, Billing.MINUTE, 7));
}