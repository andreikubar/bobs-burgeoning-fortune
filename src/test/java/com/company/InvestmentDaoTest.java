package com.company;


import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class InvestmentDaoTest {

    @Test
    public void readInvestmentsFromFile() {
        InvestmentDao investmentDao = new InvestmentDao("test_bobs_crypto.txt");
        Investment bitcoin = new Investment("BTC");
        bitcoin.setQuantity(10L);
        assertEquals(3, investmentDao.getInvestments().size());
        assertTrue(investmentDao.getInvestments().contains(bitcoin));
        Investment bitcoinParsed =
                investmentDao.getInvestments().stream().
                        filter(investment -> investment.getInstrumentKey().equals("BTC"))
                        .findFirst()
                        .get();
        assertEquals(bitcoin.getQuantity(), bitcoinParsed.getQuantity());
    }

    @Test
    public void malformedInputThrows() {
        assertThrows(RuntimeException.class, () -> new InvestmentDao("malformed.txt"));
    }

}
