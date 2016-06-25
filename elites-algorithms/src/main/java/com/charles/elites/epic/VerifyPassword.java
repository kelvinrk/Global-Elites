package com.charles.elites.epic;

public class VerifyPassword {
	public static boolean verifyPasswd(String passwd) {
		if (!checkLen(passwd))
			return false;
		if (!checkChar(passwd))
			return false;
		if (!checkSeq(passwd))
			return false;
		return true;
	}
	private static boolean checkSeq(String passwd) {
		for (int i = 0; i < passwd.length(); i++) {
			char c1 = passwd.charAt(i);
			int nextIndex = passwd.indexOf(c1, i + 1);

			while (nextIndex != -1) {
				String s1 = passwd.substring(i, nextIndex);
				if (2 * nextIndex - i <= passwd.length()) {
					String s2 = passwd.substring(nextIndex, 2 * nextIndex - i);
					if (s1.equals(s2)) {
						return false;
					}
				}
				nextIndex = passwd.indexOf(c1, nextIndex + 1);
			}

		}
		return true;
	}
	private static boolean checkChar(String passwd) {
		char[] chars = passwd.toCharArray();
		boolean num_flag = false;
		boolean lowercase_flag = false;
		for (int i = 0; i < chars.length; i++) {
			if (chars[i] >= '0' && chars[i] <= '9') {
				num_flag = true;
			}
			if (chars[i] >= 'a' && chars[i] <= 'z') {
				lowercase_flag = true;
			}
		}
		if (num_flag && lowercase_flag) {
			return true;
		}
		return false;
	}
	private static boolean checkLen(String passwd) {
		if (passwd.length() < 5 || passwd.length() > 12) {
			return false;
		}
		return true;
	}
	public static void main(String[] args) {
		System.out.println(verifyPasswd("asfh12323"));
	}

}