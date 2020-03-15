package com.vlasova.builder;

public enum TariffTag {
    BILLING("billing"),
    CALL_PRICES("callPrices"),
    CALL_PRICE_INSIDE_THE_NETWORK("callPriceInsideTheNetwork"),
    CALL_PRICE_OUTSIDE_THE_NETWORK("callPriceOutsideTheNetwork"),
    CALL_PRICE_TO_STATIONARY_PHONE("callPriceToStationaryPhone"),
    ID("id"),
    FEE_CONNECTION("feeConnection"),
    NUMBER_OF_THE_FAVORITE_NUMBERS("numberOfTheFavoriteNumbers"),
    OPERATOR_NAME("operatorName"),
    PAYROLL("payroll"),
    PARAMETERS("parameters"),
    TARIFF_NAME("tariffName"),
    TARIFFS("tariffs"),
    TARIFF("tariff"),
    SMS_PRICES("smsPrices"),
    SMS_PRICE_INSIDE_THE_NETWORK("smsPriceInsideTheNetwork"),
    SMS_PRICE_OUTSIDE_THE_NETWORK("smsPriceOutsideTheNetwork");
    private String value;
    private static final String UNDERSCORE = "_";
    private static final String DASH = "-";

    private TariffTag(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static String toEnumFormat(String name) {
        return name.replaceAll(DASH, UNDERSCORE).toUpperCase();
    }

    public String toTag() {
        return name().replaceAll(UNDERSCORE, DASH).toLowerCase();
    }
}
