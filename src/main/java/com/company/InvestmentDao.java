package com.company;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class InvestmentDao {

    private final String fileName;
    private final List<Investment> investments = new ArrayList<>();

    public InvestmentDao(String fileName) {
        this.fileName = fileName;
        loadInvestmentsFromFile();
    }

    public List<Investment> getInvestments() {
        return investments;
    }

    private void loadInvestmentsFromFile() {
        try (FileReader fileReader = new FileReader(this.getClass().getResource(fileName).getFile());
             BufferedReader bufferedReader = new BufferedReader(fileReader)) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                investments.add(fromFileLine(line));
            }
        } catch (IOException e) {
            throw new RuntimeException("Failed to read input file with Bob's portfolio", e);
        }
    }

    private static Investment fromFileLine(String line) {
        Investment parsedInvestment;
        int delimiterPosition = line.indexOf("=");
        try {
            String key = line.substring(0, delimiterPosition);
            String quantity = line.substring(delimiterPosition + 1);
            parsedInvestment = new Investment(key);
            parsedInvestment.setQuantity(Long.parseLong(quantity));
        } catch (Exception e) {
            throw new RuntimeException("Invalid line passed, cannot parse to an investment: " + line, e);
        }
        return parsedInvestment;
    }
}
