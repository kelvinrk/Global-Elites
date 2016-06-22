package com.charles.elites.epic;

public class FibbonaciNumber {
	public static void main(String[] args) {
		find(1000, 100000);
	}

	private static void find(int a, int b) {
		for (int i = a; i <= b; i++) {
			if (check(i))
				System.out.println(i);
		}
	}
	public static boolean check(int number) {
		String num = String.valueOf(number);
		for (int i = 1; i < num.length(); i++) {
			int num1 = Integer.parseInt(num.substring(0, i));

			for (int j = i + 1; j < num.length(); j++) {
				int temp_num1 = num1;
				int num2 = Integer.parseInt(num.substring(i, j));
				if(num1 != num2)
					break;
				int thirdIndex = j;
				int rest = Integer.parseInt(num.substring(thirdIndex,
						num.length()));
				while (temp_num1 + num2 <= rest) {
					int num3 = temp_num1 + num2;
					String newNum = (new Integer(num3)).toString();
					int length = newNum.length();
					if (thirdIndex + length > num.length()) {
						break;
					}
					if (num.substring(thirdIndex, thirdIndex + length).equals(
							newNum)) {
						thirdIndex += length;
						if (thirdIndex == num.length()) {
							return true;
						}
						temp_num1 = num2;
						num2 = num3;
						rest = Integer.parseInt(num.substring(thirdIndex,
								num.length()));

					} else {
						break;
					}
				}
			}
		}
		return false;
	}
}
