package com.vlasova.runner;

import com.vlasova.builder.TariffsBuilder;
import com.vlasova.builder.TariffsFactory;

public class Main {
    public static void main(String[] args) {
        TariffsFactory factory = new TariffsFactory();
        TariffsBuilder builder = factory.createTariffsBuilder("stax");
        builder.buildTariffs("src/main/resources/tariffs.xml");
        System.out.println(builder.getTariffs());
    }
}
