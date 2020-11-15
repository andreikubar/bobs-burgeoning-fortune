package com.company;

import org.junit.Assert;
import org.junit.Test;

public class InvestmentTest {
    @Test
    public void calculateTotal() {
        Investment btc = new Investment("BTC");
        btc.setQuantity(5);
        btc.setInstrumentPrice(10.0);
        Assert.assertEquals(50.0, btc.getTotalPrice(), 0.001);
    }
}
