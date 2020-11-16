package com.company;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        InvestmentDao investmentDao = new InvestmentDaoImpl("bobs_crypto.txt");
        CryptoPriceRestClient cryptoPriceRestClient = new CryptoPriceRestClient();
        InvestmentService investmentService = new InvestmentService(cryptoPriceRestClient, investmentDao);
        List<Investment> investments = investmentService.getInvestmentsWithPrices();
        for (Investment investment : investments) {
            System.out.printf("%-10s%10.2f EUR%n", investment.getInstrumentKey(), investment.getTotalPrice());
        }
        double totalValue = investments.stream().mapToDouble(Investment::getTotalPrice).sum();
        System.out.println("-".repeat(25));
        System.out.printf("%-10s %.2f EUR", "Total:", totalValue);
    }

}
