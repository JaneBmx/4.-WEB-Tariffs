package com.vlasova.runner;

import com.vlasova.builder.TariffsBuilder;
import com.vlasova.factory.CommandFactory;

public class Main {
    public static void main(String[] args) {
        CommandFactory factory = new CommandFactory();
        TariffsBuilder builder = factory.createCommand("stax");
        builder.buildTariffs("src/main/resources/tariffs.xml");
        System.out.println(builder.getTariffs());
    }
}
