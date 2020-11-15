package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class CryptoPriceRestClient {

    public double getPrice(Investment investment) {
        URL url = buildURL(investment.getInstrumentKey());
        StringBuilder response;
        try {
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestProperty("accept", "application/json");
            try (InputStream responseStream = connection.getInputStream();
                 InputStreamReader inputStreamReader = new InputStreamReader(responseStream);
                 BufferedReader bufferedReader = new BufferedReader(inputStreamReader)) {
                response = new StringBuilder();
                String inputLine;
                while ((inputLine = bufferedReader.readLine()) != null) {
                    response.append(inputLine);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        String priceJson = response.toString();
        return (new PriceMapper()).parsePriceJson(priceJson);
    }

    private URL buildURL(String key) {
        URL url;
        try {
            String cryptocompare = "https://min-api.cryptocompare.com/data/price?fsym=%s&tsyms=EUR";
            url = new URL(String.format(cryptocompare, key));
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
        return url;
    }
}
