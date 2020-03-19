package com.vlasova.builder;

import com.vlasova.entity.Tariff;

import java.util.ArrayList;
import java.util.List;

public abstract class TariffsBuilder {
    protected List<Tariff> tariffs;

    public TariffsBuilder() {
        tariffs = new ArrayList<>();
    }

    public List<Tariff> getTariffs() {
        return tariffs;
    }

    public abstract void buildTariffs(String path);
}