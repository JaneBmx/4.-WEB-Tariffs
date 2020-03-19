package com.vlasova.builder.dom;

import com.vlasova.entity.Tariff;
import com.vlasova.builder.TariffsBuilderTestData;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class DOMTariffsBuilderTest {
    @Test
    public void buildTariffs() {
        DOMTariffsBuilder dom = new DOMTariffsBuilder();
        dom.buildTariffs(TariffsBuilderTestData.FILE_NAME);
        List<Tariff> result = dom.getTariffs();
        Assert.assertEquals(result.get(0), TariffsBuilderTestData.TARIFF);
    }
}