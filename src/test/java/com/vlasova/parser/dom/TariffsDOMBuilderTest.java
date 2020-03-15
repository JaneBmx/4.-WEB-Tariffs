package com.vlasova.parser.dom;

import com.vlasova.entity.Tariff;
import com.vlasova.parser.TariffsBuilderTestData;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class TariffsDOMBuilderTest {
    @Test
    public void buildTariffs() {
        TariffsDOMBuilder dom = new TariffsDOMBuilder();
        dom.buildTariffs(TariffsBuilderTestData.FILE_NAME);
        Set<Tariff> result = dom.getTariffs();
        List<Tariff> list = new ArrayList<>(result);
        Assert.assertEquals(list.get(0), TariffsBuilderTestData.TARIFF);
    }
}