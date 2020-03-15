package com.vlasova.parser.sax;

import com.vlasova.entity.Tariff;
import com.vlasova.parser.TariffsBuilderTestData;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class TariffsSAXBuilderTest {
    @Test
    public void buildTariffs() {
        TariffsSAXBuilder sax = new TariffsSAXBuilder();
        sax.buildTariffs(TariffsBuilderTestData.FILE_NAME);
        Set<Tariff> result = sax.getTariffs();
        List<Tariff> list = new ArrayList<>(result);
        Assert.assertEquals(list.get(0), TariffsBuilderTestData.TARIFF);
    }
}