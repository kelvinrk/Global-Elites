/**
 * 
 */
package com.charles.elites.amazon.oa1;

public class LongestPalindromeSubstring {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(longestPalindromeSubstring("banana"));
		System.out.println(longestPalindromeSubstring("askfhabcdedcbafdjgah"));
	}
	public static String longestPalindromeSubstring(String s) {
		String res = preprocess(s);
		 int[] p = new int[res.length()]; //Store the radius of current palindrome substring whose center is i
		 int r = 0; //Record the most right position for palindrome substring
		 int c = 0; //Record the value of i when current best r gotten
		 for(int i = 1; i < res.length() - 1; i++) {
			 if(i >= r)
				 p[i] = 0;
			 else
				 //Can avoid re-matching
				 p[i] = Math.min(p[2*c - i], r - i);
			 while(res.charAt(i + p[i]+ 1) == res.charAt(i - p[i] - 1))
				 p[i]++;
			 if(i + p[i] > r) {
				 c = i;
				 r = i + p[i];
			 }
		 }
		 int max = 0;
		 int center = 0;
		 for(int i = 1; i < p.length - 1; i++) {
			 System.out.print(p[i]);
			 if(p[i] > max) {
				 max = p[i];
				 center = i;
			 }
		 }
		 return s.substring((center - 1 - max) / 2, (center - 1 + max) / 2);
	}
	
	private static String preprocess(String s) {
		StringBuilder sb = new StringBuilder();
		//Add a special char at the begin and the end, which can help to avoid out of array bounds
		sb.append("^");
		for(int i = 0; i < s.length(); i++) {
			sb.append("#");
			sb.append(s.charAt(i));
		}
		sb.append("#$");
		System.out.println(sb.toString());
		return sb.toString();
	}
}
