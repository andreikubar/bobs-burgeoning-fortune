package com.company;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class InvestmentServiceTest {
    @Test
    public void updatePrices() {
        CryptoPriceRestClient cryptoPriceRestClientMock = mockCryptoPriceRestClient();
        InvestmentService investmentService = new InvestmentService(cryptoPriceRestClientMock);
        List<Investment> investments = List.of(
                new Investment("BTC")
        );
        investmentService.updateInvestmentPrices(investments);
        assertEquals(10.0, investments.get(0).getInstrumentPrice(), 0.001);
    }

    private CryptoPriceRestClient mockCryptoPriceRestClient() {
        return new CryptoPriceRestClient() {
            @Override
            public double getPrice(Investment investment) {
                if (investment.getInstrumentKey().equals("BTC")) {
                    return 10.0;
                }
                else {
                    return 0.0;
                }
            }
        };
    }
}
