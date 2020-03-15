package com.vlasova.parser;

import com.vlasova.entity.Tariff;

import java.util.HashSet;
import java.util.Set;

public abstract class TariffsBuilder {
    protected Set<Tariff> tariffs;

    public TariffsBuilder() {
        tariffs = new HashSet<>();
    }

    public Set<Tariff> getTariffs() {
        return tariffs;
    }

    public abstract void buildTariffs(String path);
}