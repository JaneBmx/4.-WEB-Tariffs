package com.vlasova.builder.stax;

import com.vlasova.entity.Tariff;
import com.vlasova.builder.TariffsBuilderTestData;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class StAXTariffsBuilderTest {
    @Test
    public void buildTariffs() {
        StAXTariffsBuilder stax = new StAXTariffsBuilder();
        stax.buildTariffs(TariffsBuilderTestData.FILE_NAME);
        List<Tariff> result = stax.getTariffs();
        Assert.assertEquals(result.get(0), TariffsBuilderTestData.TARIFF);
    }
}