package com.charles.elites.epic;

public class AdditiveNumber {
	public static void main(String[] args) {
//		for (int i = 1000; i < 10000; i++)
//			if (isAdditiveNumber(String.valueOf(i)))
//				System.out.println(i);
		int[] a = {2,3,4,5,6,7,8,9,10,11,12,14,15};
		System.out.println(findMissing(a));
	}
	public static boolean isAdditiveNumber(String nums) {
		int len = nums.length();
		if (len <= 1)
			return true;
		for (int i = 1; i < len; i++) {
			String p1 = nums.substring(0, i);
			for (int j = i + 1; j < len; j++) {
				String p2 = nums.substring(i, j);
				String p3 = String.valueOf(Integer.parseInt(p1)
						+ Integer.parseInt(p2));
				int index = j + 1;
				int temp_j = j;
				while (len - temp_j >= p3.length()) {
					if (index > len)
						break;
					if (p3.equals(nums.substring(temp_j, index))) {
						int temp_i = i;
						while (temp_i < len && temp_i < index) {
							if (isAdditiveNumber(nums.substring(temp_i, len)))
								return true;
							temp_i++;
						}

					}
					index++;
				}
			}
		}
		return false;
	}

	private static Integer findMissing(int[] nums) {
		if(nums == null || nums.length < 2)
			return -1;
		int left = 0;
		int right = nums.length - 1;
		while(left < right) {
			int mid = (left + right) / 2;
			int diffLen = right - mid;
			int diff = nums[right] - nums[mid];

			if(diff > diffLen) {
				left = mid + 1;
			} else {
				right = mid;
			}
		}

		if(left > 0)
			return nums[right] - 1;
		return -1;
	}
}
