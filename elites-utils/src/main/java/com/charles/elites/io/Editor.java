package com.charles.elites.io;

/**
 * Created by Kelvin.R.K on 6/28/2016.
 */
public class Editor {
    public static void main(String[] args) {
        StringBuilder builder = new StringBuilder();
        for(int i = 0; i < 1000; i++) {
            builder.append("dataStruct.addOrUpdate(")
                    .append(Generator.generateIneger(1, 200))
                    .append(",")
                    .append(Generator.generateIneger(5, 50))
                    .append(");\n");
        }
        String s = builder.toString();
        System.out.println(s);
        Generator.copyToClipBoard(s);
    }
}
