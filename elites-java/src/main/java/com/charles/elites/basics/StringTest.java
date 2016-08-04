package com.charles.elites.basics;

import java.util.LinkedList;

/**
 * Created by Kelvin.R.K on 7/12/2016.
 */
public class StringTest {
    public static void main(String[] args) {
        String s = "abc";
        System.out.println(s.substring(1,1));

        s += s.charAt(1);
        StringBuilder builder = new StringBuilder();
        builder.append(s).append(s.charAt(1));
        System.out.println(builder.toString());
    }
}
