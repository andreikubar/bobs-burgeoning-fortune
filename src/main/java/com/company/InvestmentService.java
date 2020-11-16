package com.company;

import java.util.List;

public class InvestmentService {

    private final CryptoPriceRestClient cryptoPriceRestClient;
    private final InvestmentDao investmentDao;

    public InvestmentService(CryptoPriceRestClient cryptoPriceRestClient, InvestmentDao investmentDao) {
        this.cryptoPriceRestClient = cryptoPriceRestClient;
        this.investmentDao = investmentDao;
    }

    public List<Investment> getInvestmentsWithPrices() {
        List<Investment> investments = investmentDao.getInvestments();
        updateInvestmentPrices(investments);
        return investments;
    }
    private void updateInvestmentPrices(List<Investment> investmentList) {
        for (Investment investment : investmentList) {
            double cryptoPrice = cryptoPriceRestClient.getPrice(investment);
            investment.setInstrumentPrice(cryptoPrice);
        }
    }
}
