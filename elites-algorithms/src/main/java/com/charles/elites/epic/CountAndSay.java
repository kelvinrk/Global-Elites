package com.charles.elites.epic;

public class CountAndSay {
	public static void main(String[] args) {
		countandsay(1);
	}
	private static void countandsay(int num) {
		String s = String.valueOf(num);
        int count = 1;
        for(int i = 0; i < 10; i++) {
            count = 1;
            StringBuilder sb = new StringBuilder();
            for(int j = 1; j < s.length(); j++) {
                if(s.charAt(j) == s.charAt(j - 1))
                    count++;
                else {
                    sb.append(count).append(s.charAt(j - 1));
                    count = 1;
                }
            }
            sb.append(count).append(s.charAt(s.length() - 1));
            s = sb.toString();
            System.out.println(s);
        }
	}
}
