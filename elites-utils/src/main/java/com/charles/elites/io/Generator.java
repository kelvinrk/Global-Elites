package com.charles.elites.io;

import org.apache.commons.lang.WordUtils;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.util.Random;

/**
 * Created by wangzhiy on 6/28/2016.
 */
public final class Generator {

    private static Random random = new Random();

    private static char[] letters = "abcdefghijklmnopqrstuvwxyz".toCharArray();

    public static void main(String[] args) {
        generateString(8, true);
    }


    public static String generateString(int length, boolean camel) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < length; i++) {
            char c = letters[random.nextInt(letters.length)];
            sb.append(c);
        }
        String output = sb.toString();
        if(camel)
            output = WordUtils.capitalize(output);
        return output;
    }

    public static int generateIneger(int min, int max) {
        if(min >= max)
            return Integer.MIN_VALUE;
        return random.nextInt((max - min) + 1) + min;
    }

    public static void copyToClipBoard(String s) {
        StringSelection stringSelection = new StringSelection(s);
        Clipboard clpbrd = Toolkit.getDefaultToolkit().getSystemClipboard();
        clpbrd.setContents(stringSelection, null);
    }
}
