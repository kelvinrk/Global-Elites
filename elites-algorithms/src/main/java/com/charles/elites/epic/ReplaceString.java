package com.charles.elites.epic;

public class ReplaceString {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(stringReplace("I am A boy."));
	}
	private static String stringReplace(String str) {
		String regex = " ";
		String str1 = "a";
		String str2 = "A";
		StringBuilder sb = new StringBuilder();
		String[] parts = str.split(regex);
		for (int i = 0; i < parts.length; i++) {
			if (parts[i].equals(str1))
				sb.append("one");
			else if (parts[i].equals(str2))
				sb.append("ONE");
			else
				sb.append(parts[i]);
			if (i < parts.length - 1)
				sb.append(" ");
		}
		return sb.toString();
	}
}
