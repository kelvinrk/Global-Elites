package com.charles.elites.quest;

public class RemoveRepetitions {
    public static String transform(String input) {
        if(input == null || input.length() < 2)
            return input;
        int p = 0;
        StringBuilder sb = new StringBuilder();
        sb.append(input.charAt(0));
        for(int i = 0; i < input.length(); i++) {
            if(input.charAt(i) == input.charAt(p)) {
                continue;
            } else {
                sb.append(input.charAt(i));
                p = i;
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(RemoveRepetitions.transform("abbcbbb"));
    }
}