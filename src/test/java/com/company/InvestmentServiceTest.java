package com.company;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class InvestmentServiceTest {
    @Test
    public void updatePrices() {
        List<Investment> investments = List.of(
                new Investment("BTC")
        );
        CryptoPriceRestClient cryptoPriceRestClientMock = mockCryptoPriceRestClient();
        InvestmentDao investmentDao = mockInvestmentDao(investments);
        InvestmentService investmentService = new InvestmentService(cryptoPriceRestClientMock, investmentDao);
        List<Investment> investmentsWithPrices = investmentService.getInvestmentsWithPrices();
        assertEquals(10.0, investmentsWithPrices.get(0).getInstrumentPrice(), 0.001);
    }

    private CryptoPriceRestClient mockCryptoPriceRestClient() {
        return new CryptoPriceRestClient() {
            @Override
            public double getPrice(Investment investment) {
                if (investment.getInstrumentKey().equals("BTC")) {
                    return 10.0;
                } else {
                    return 0.0;
                }
            }
        };
    }

    private InvestmentDao mockInvestmentDao(List<Investment> investments) {
        return new InvestmentDao() {
            @Override
            public List<Investment> getInvestments() {
                return investments;
            }
        };
    }
}
