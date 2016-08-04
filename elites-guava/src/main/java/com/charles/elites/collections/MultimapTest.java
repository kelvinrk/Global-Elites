package com.charles.elites.collections;

import com.charles.elites.objects.FlowType;
import com.charles.elites.objects.Stock;
import com.google.common.base.Function;
import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.HashMultimap;
import com.google.common.collect.ImmutableListMultimap;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.ListMultimap;
import com.google.common.collect.Multimap;
import com.google.common.collect.Multimaps;
import com.google.common.collect.SetMultimap;
import com.google.common.collect.SortedSetMultimap;
import com.google.common.collect.TreeMultimap;
import com.google.common.primitives.Ints;

import java.util.EnumSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by Kelvin.R.K on 4/25/2016.
 */
public class MultimapTest {

    private final static String[] traders = {"Kelvin", "Syer", "Charles", "Nathan"};

    public static void main(String[] args) {
//        testListMultiMap();
//        testSetMultiMap();
//        testSortedSetMultimap();
//        generateMapByAttribute();
        whoCoverThisStock();
//        testForMap();
    }

    public static void testListMultiMap() {
        ListMultimap<String, String> map = ArrayListMultimap.create();

        addContent(map);
        List<String> lastNames = map.get("Kelvin");

        for(String s : lastNames)
            System.out.println(s);

        if(lastNames.contains("Charles"))
            System.out.println("**********Charles founded**********");
        enumFunction(FlowType.class);
    }

    public static void testSetMultiMap() {
        SetMultimap<String, String> traderCoverageMap = HashMultimap.create();
        addContent(traderCoverageMap);

        Set<String> set =  traderCoverageMap.get("Kelvin");

        System.out.println(traderCoverageMap);
        System.out.println("set.size() = " + set.size());
        System.out.println("set.contains(\"AAPL\"): " + set.contains("AAPL"));

        System.out.println("traderCoverageMap.size() = " + traderCoverageMap.size());
        System.out.println("traderCoverageMap.keySet().size() = " + traderCoverageMap.keySet().size());
        System.out.println("traderCoverageMap.entries().size() = " + traderCoverageMap.entries().size());
        System.out.println("traderCoverageMap.entries(): " + traderCoverageMap.entries());

        traderCoverageMap.entries().stream().filter(entry -> entry.getValue().equals("AAPL"))
                .forEach(entry -> System.out.println(entry.getKey()));

        System.out.println("***************** Begin search *****************");
        for(String s : traders) {
            Set<String> symbol =  traderCoverageMap.get(s);
            if(symbol.contains("AAPL"))
                System.out.println(s);
        }

        TreeMultimap<String, String> dest = TreeMultimap.create();
        TreeMultimap<String, String> inverse = Multimaps.invertFrom(traderCoverageMap, dest);
        System.out.println("Who cover this stock? \n" + inverse);
    }

    public static void testSortedSetMultimap() {
        SortedSetMultimap<String, String> traderCoverageMap = TreeMultimap.create();
        addContent(traderCoverageMap);

        System.out.println(traderCoverageMap);
    }

    public static void generateMapByAttribute() {
        ImmutableSet<String> digits = ImmutableSet.of("zero", "one", "two", "three", "four",
                "five", "six", "seven", "eight", "nine");
//        Function<String, Integer> lengthFunction = s -> s.length();
//        ImmutableListMultimap<Integer, String> digitsByLength = Multimaps.index(digits, lengthFunction);
//        System.out.println(digitsByLength);
        Function<String, Character> lengthFunction = s -> s.charAt(0);
        ImmutableListMultimap<Character, String> digitsByFirstLetter = Multimaps.index(digits, lengthFunction);
        System.out.println(digitsByFirstLetter);
    }

    public static void whoCoverThisStock() {
        ArrayListMultimap<String, Integer> multimap = ArrayListMultimap.create();
        multimap.putAll("b", Ints.asList(2, 4, 6));
        multimap.putAll("a", Ints.asList(4, 2, 1));
        multimap.putAll("c", Ints.asList(2, 5, 3));

        TreeMultimap<Integer, String> dest = TreeMultimap.create();
        TreeMultimap<Integer, String> inverse = Multimaps.invertFrom(multimap, dest);

//        System.out.println(inverse);
        System.out.println(dest);
    }

    public static void testForMap() {
        Map<String, Integer> map = ImmutableMap.of("a", 1, "b", 1, "c", 2);
        SetMultimap<String, Integer> multimap = Multimaps.forMap(map);
        Multimap<Integer, String> inverse = Multimaps.invertFrom(multimap, HashMultimap.<Integer, String> create());
        System.out.println(inverse);
    }

    public static void testCustomObjectMultimap() {
        //Object must implement Comparable
        Multimap<String, Stock> traderCoverageMap = TreeMultimap.create();
        addStock(traderCoverageMap);
    }

    public static void addContent(Multimap map) {
        map.put("Kelvin", "AAPL");
        map.put("Kelvin", "AMZN");
        map.put("Kelvin", "FB");
        map.put("Kelvin", "GOOG");
        map.put("Syer", "AAPL");
        map.put("Charles", "AMZN");
        map.put("Syer", "FB");
        map.put("Charles", "GOOG");
        map.put("Nathan", "ATVI");
        map.put("Nathan", "XOM");
    }

    public static void addStock(Multimap map) {
        map.put("Kelvin", new Stock("AAPL", 100));
        map.put("Kelvin", new Stock("FB", 120));
        map.put("Syer", new Stock("AMZN", 600));
        map.put("Nathan", new Stock("XOM", 80));
    }

    public static void enumFunction(Class<? extends Enum> enumType) {

        for (Object o : EnumSet.allOf(enumType)) {
            System.out.println(o.toString());
        }
    }

}
