package com.company;

import java.util.Objects;

public class Investment {
    private final String instrumentKey;
    private long quantity;
    private double instrumentPrice;

    public Investment(String instrumentKey) {
        this.instrumentKey = instrumentKey;
    }

    public String getInstrumentKey() {
        return instrumentKey;
    }

    public long getQuantity() {
        return quantity;
    }

    public void setQuantity(long quantity) {
        this.quantity = quantity;
    }

    public double getInstrumentPrice() {
        return instrumentPrice;
    }

    public void setInstrumentPrice(double instrumentPrice) {
        this.instrumentPrice = instrumentPrice;
    }

    public double getTotalPrice() {
        return quantity * instrumentPrice;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Investment that = (Investment) o;
        return instrumentKey.equals(that.instrumentKey);
    }

    @Override
    public int hashCode() {
        return Objects.hash(instrumentKey);
    }

    @Override
    public String toString() {
        return "Investment{" +
                "instrumentKey='" + instrumentKey + '\'' +
                ", quantity=" + quantity +
                ", instrumentPrice=" + instrumentPrice +
                '}';
    }
}
