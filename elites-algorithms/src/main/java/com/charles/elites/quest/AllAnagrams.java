package com.charles.elites.quest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Kelvin.R.K on 6/26/2016.
 */
public class AllAnagrams {
    public static Collection<String> getAllAnagrams(String string) {
        List<String> res = new ArrayList<String>();
        if(string == null || string.length() == 0)
            return res;
        char[] s = string.toCharArray();
        Arrays.sort(s);
        res.add("");

        for(int i = 0; i < s.length; i++) {
            Set<String> cur = new HashSet<String>();
            for(String each : res) {
                for(int j = 0; j <= each.length(); j++) {
                    StringBuilder sb = new StringBuilder(each);
                    sb.insert(j, s[i]);
                    cur.add(sb.toString());
                    sb.deleteCharAt(j);
                }
            }
            res = new ArrayList<String>(cur);
        }
        return res;
    }

    public static void main(String[] args) {
        Collection<String> anagrams = getAllAnagrams("abba");
        for (String a : anagrams)
            System.out.println(a);
    }
}