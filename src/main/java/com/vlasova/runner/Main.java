package com.vlasova.runner;

import com.vlasova.parser.TariffsBuilder;
import com.vlasova.parser.TariffsFactory;

public class Main {
    public static void main(String[] args) {
        TariffsFactory factory = new TariffsFactory();
        TariffsBuilder builder = factory.createTariffsBuilder("stax");
        builder.buildTariffs("src/main/resources/tariffs.xml");
        System.out.println(builder.getTariffs());
    }
}
