package com.charles.elites.quest;

public class Run {
    public static int indexOfLongestRun(String str) {
        if(str == null || str.length() <= 1)
            return 0;
        int index = 0;
        int max = 1;
        for(int i = 0; i < str.length() - 1; i++) {
            int cur = i;
            while((i + 1) < str.length() && str.charAt(i) == str.charAt(i + 1))
                i++;
            int len = i - cur + 1;
            if(len > max) {
                max = len;
                index = cur;
            }
        }
        return index;
    }

    public static void main(String[] args) {
        System.out.println(indexOfLongestRun("abbcccddddcccbba"));
    }
}