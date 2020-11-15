package com.company;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PriceMapper {
    public double parsePriceJson(String json){
        Pattern pattern = Pattern.compile("\\{\"EUR\":(\\d+(?:\\.\\d+)?)\\}");
        Matcher matcher = pattern.matcher(json);
        if (matcher.matches()) {
            return Double.parseDouble(matcher.group(1));
        }
        else {
            throw new RuntimeException("Failed to parse json " + json);
        }
    }
}
