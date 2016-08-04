package com.charles.elites.bloomberg;

import com.charles.elites.io.Output;

import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * Created by Kelvin.R.K on 7/5/2016.
 */
public class StockStream {
    static int MAX_CAPACITY = 3;
    static LinkedHashMap<String, Integer> stockInfo = new LinkedHashMap<String ,Integer>(MAX_CAPACITY, 0.75f, true) {
        @Override
        protected boolean removeEldestEntry(Map.Entry eldest) {
            if(size() > MAX_CAPACITY) {
                return true;
            }
            return false;
        }
    };

    static PriorityQueue<Stock> queue;

    public static void main(String[] args) {
        testStockQueue();
    }

    private static void testStockInfo() {
        stockInfo.put("QQQ", 55);
        stockInfo.put("BND", 40);
        stockInfo.put("JNJ", 110);
        stockInfo.put("AAPL", 100);
        stockInfo.put("GOOG", 500);
        stockInfo.put("GOOG", 501);
        stockInfo.put("GOOG", 605);
        stockInfo.put("AAPL", 102);
        stockInfo.put("MSFT", 60);
        stockInfo.put("LMT", 120);

        System.out.println(stockInfo.size());
        Output.print(stockInfo);
    }

    private static void testStockQueue() {
        Comparator<Stock> comparator = (o1, o2) -> o2.count - o1.count;

        queue = new PriorityQueue<>(10, comparator);

        updateQueue(new Stock("AAPL", 100));
        updateQueue(new Stock("AAPL", 105));
        updateQueue(new Stock("GOOG", 500));
        updateQueue(new Stock("LMT", 88));
        updateQueue(new Stock("QQQ", 62));
        updateQueue(new Stock("AAPL", 110));
        updateQueue(new Stock("GOOG", 600));
        updateQueue(new Stock("AMZN", 666));
        updateQueue(new Stock("AAPL", 108));
        updateQueue(new Stock("GOOG", 540));

        System.out.println(queue.size());
        for(Stock stock : queue)
            System.out.println(stock);
    }

    private static void updateQueue(Stock stock) {
        Iterator<Stock> iterator = queue.iterator();
        Stock current = null;
        while (iterator.hasNext()) {
            current = iterator.next();
            if (current.equals(stock)) {
                queue.remove(current);
                stock.setCount(current.count + 1);
                queue.offer(stock);
                break;
            }
        }

        if(current == null || !current.equals(stock))
            queue.offer(stock);
    }
}

class Stock {
    String name;
    int price;
    int count;

    public Stock(String name, int price) {
        this.name = name;
        this.price = price;
        count = 1;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) return true;
        if (that == null || this.getClass() != that.getClass()) return false;

        Stock stock = (Stock) that;

        return name != null ? name.equals(stock.name) : stock.name == null;
    }

    @Override
    public int hashCode() {
        return name != null ? name.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Stock{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", count=" + count +
                '}';
    }
}

