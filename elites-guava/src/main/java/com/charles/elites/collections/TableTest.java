package com.charles.elites.collections;

import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Maps;
import com.google.common.collect.Table;
import com.google.common.collect.Tables;
import com.google.common.collect.TreeBasedTable;

import java.util.Comparator;
import java.util.Map;

/**
 * Created by Kelvin.R.K on 5/10/2016.
 */
public class TableTest {
    public static void main(String[] args) {
//        testHashBasedTable();
//        testTreeBasedTable();
        testTransposedTable();
    }

    /**
     * Instead of using this
     * Map<FirstName, Map<LastName, Person>>
     */
    public static void testHashBasedTable() {
        Table<String, String, Integer> table = HashBasedTable.create();
        addContent(table);
        System.out.println(table.column("Real Madrid").get("Bale"));
    }

    public static void testTreeBasedTable() {
        //Desc
//        Comparator<? super String> rowComparator = (o1, o2) -> o2.compareToIgnoreCase(o1);
        //Asc
        Comparator<? super String> rowComparator = (o1, o2) -> o1.compareToIgnoreCase(o2);
        Comparator<? super String> columnComparator = (o1, o2) -> o1.compareToIgnoreCase(o2);

        Table<String, String, Integer> table = TreeBasedTable.create(rowComparator, columnComparator);
//        Table<String, String, Integer> table = TreeBasedTable.create();

        addContent(table);

        System.out.println(table.column("Real Madrid"));
    }

    public static void addContent(Table<String, String, Integer> table) {
        table.put("Cristiano Ronaldo", "Real Madrid", 7);
        table.put("Bale", "Real Madrid", 11);
        table.put("Benzema", "Real Madrid", 9);
        table.put("Messi", "Barcelona", 10);
        table.put("Neymar", "Barcelona", 11);
        table.put("suarez ", "Barcelona", 9);
    }

    public static void testTransposedTable() {
        Table<String, String, Integer> table = HashBasedTable.create();
        addContent(table);
        System.out.println("Original Table: " + table);
        System.out.println("Transposed Tabl: " + Tables.transpose(table));
    }

    public static void testCustomTable() {
        Table<String, Character, Integer> table = Tables.newCustomTable(
                Maps.<String, Map<Character, Integer>>newLinkedHashMap(), () -> Maps.newLinkedHashMap());
    }
}
