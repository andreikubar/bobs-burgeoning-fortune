package com.company;

import java.util.List;

public class InvestmentService {

    private final CryptoPriceRestClient cryptoPriceRestClient;

    public InvestmentService(CryptoPriceRestClient cryptoPriceRestClient) {
        this.cryptoPriceRestClient = cryptoPriceRestClient;
    }

    public void updateInvestmentPrices(List<Investment> investmentList) {
        for (Investment investment : investmentList) {
            double cryptoPrice = cryptoPriceRestClient.getPrice(investment);
            investment.setInstrumentPrice(cryptoPrice);
        }
    }
}
