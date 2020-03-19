package com.vlasova.builder.sax;

import com.vlasova.entity.Tariff;
import com.vlasova.builder.TariffsBuilderTestData;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class SAXTariffsBuilderTest {
    @Test
    public void buildTariffs() {
        SAXTariffsBuilder sax = new SAXTariffsBuilder();
        sax.buildTariffs(TariffsBuilderTestData.FILE_NAME);
        List<Tariff> result = sax.getTariffs();
        List<Tariff> list = new ArrayList<>(result);
        Assert.assertEquals(list.get(0), TariffsBuilderTestData.TARIFF);
    }
}