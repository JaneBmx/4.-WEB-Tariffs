package com.vlasova.parser.stax;

import com.vlasova.entity.Tariff;
import com.vlasova.parser.TariffsBuilderTestData;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class TariffsStAXBuilderTest {
    @Test
    public void buildTariffs() {
        TariffsStAXBuilder stax = new TariffsStAXBuilder();
        stax.buildTariffs(TariffsBuilderTestData.FILE_NAME);
        Set<Tariff> result = stax.getTariffs();
        List<Tariff> list = new ArrayList<>(result);
        Assert.assertEquals(list.get(0), TariffsBuilderTestData.TARIFF);
    }
}