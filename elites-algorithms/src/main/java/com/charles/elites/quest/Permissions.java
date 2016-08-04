package com.charles.elites.quest;

import java.util.HashMap;
import java.util.Map;

public class Permissions {
    public static int permStringToInt(String permString) {
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        map.put('r', 4);
        map.put('w', 2);
        map.put('x', 1);
        map.put('-', 0);

        if(permString == null || permString.length() != 9)
            return 0;

        int res = 0;
        for(int i = 0; i < 9; i += 3) {
            int section = 0;
            char[] temp = permString.substring(i, i + 3).toCharArray();
            for(char c : temp) {
                section += map.get(c);
            }
            res = 10 * res + section;
        }

        return res;
    }

    public static void main(String[] args) {
        // Should write 752
        System.out.println(Permissions.permStringToInt("rwxr-x-w-"));
    }
}
