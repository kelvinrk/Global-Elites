package com.charles.elites.epic;

public class RepalceWords {
	public static void main(String[] args) {
		replace("A person can't walk in this street.");
	}
	private static void replace(String s) {
		String[] st = s.split(" ");
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < st.length; i++) {
			String cur = st[i];
			if(cur.length() >= 4) {
				StringBuilder temp = new StringBuilder();
				temp.append(cur);
				temp.insert(cur.length() / 2, " ");
				sb.append(temp.toString()).append(" ");
			} else if(i != st.length - 1)
				sb.append(cur).append(" ");
			else
				sb.append(cur);
		}
		System.out.println(sb.toString());
	}
}
