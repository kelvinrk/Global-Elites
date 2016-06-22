package com.charles.elites.epic;

public class Print {
	public static void main(String[] args) {
		print(8879, 9);
	}
	private static void print(int N, int broken) {
		if(N == 0 && broken == 0)
			return;
		String tar = String.valueOf(N);
		int l = tar.length();
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < l; i++) {
			if(tar.charAt(i) - '0' != broken) {
				sb.append(tar.charAt(i));
			}else {
				replace(i, l, sb, broken);
				break;
			}
		}
		System.out.println(Integer.valueOf(sb.toString()));
	}
	private  static void replace(int i, int l, StringBuilder sb, int broken) {
		if(broken == 9) {
			while(l > i) {
				sb.append(8);
				i++;
			}
		} else if(broken == 0) {
			int temp = sb.charAt(sb.length() - 1) - '0';
			sb.deleteCharAt(sb.length() - 1);
			sb.append(temp - 1);
			while(l > i) {
				sb.append(9);
				i++;
			}
		} else {
			sb.append(broken - 1);
			i++;
			while(l > i) {
				sb.append(9);
				i++;
			}
		}
	}
}
