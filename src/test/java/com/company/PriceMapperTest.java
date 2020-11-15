package com.company;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PriceMapperTest {
    @Test
    public void mapPriceFromString() {
        PriceMapper priceMapper = new PriceMapper();
        String json = "{\"EUR\":1234.99}";
        assertEquals(1234.99, priceMapper.parsePriceJson(json), 0.001);
        json = "{\"EUR\":1234}";
        assertEquals(1234.00, priceMapper.parsePriceJson(json), 0.001);
    }
}
