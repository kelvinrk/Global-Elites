package com.charles.elites.objects;

/**
 * Created by Kelvin.R.K on 5/19/2016.
 */
public class Stock implements Comparable {
    String symbol;
    int price;

    public Stock(String symbol, int price) {
        this.symbol = symbol;
        this.price = price;
    }

    @Override
    public int compareTo(Object o) {
        return this.symbol.compareToIgnoreCase(o.toString());
    }
}
