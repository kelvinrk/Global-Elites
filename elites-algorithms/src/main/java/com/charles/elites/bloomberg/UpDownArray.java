package com.charles.elites.bloomberg;

/**
 * Created by Kelvin.R.K on 7/5/2016.
 */
public class UpDownArray {
    public static void main(String[] args) {
        int[] input = {1, 2, 3, 4, 5, 6, 7, 7, 12, 15, 22, 90, 88, 76, 39, 12, 0};
        System.out.println(find(input, 88));
    }

    private static boolean find(int[] input, int target) {
        if(input == null || input.length == 0)
            return false;
        int peak = 0;
        int l = 0;
        int r = input.length - 1;
        while(l < r) {
            int mid1 = (l + r) / 2;
            int mid2 = mid1 + 1;
            if(input[mid1] < input[mid2])
                l = mid2;
            if(input[mid1] > input[mid2])
                r = mid1;
        }
        peak = l;
        System.out.println("Peak element is " + input[peak]);
        return binarySearch(input, 0, peak, target, false) || binarySearch(input, peak + 1, input.length - 1, target, true);
    }

    private static boolean binarySearch(int[] input, int l, int r, int target, boolean reverse) {
        while(l <= r) {
            int mid = (l + r) / 2;
            if(input[mid] == target)
                return true;
            if(input[mid] > target) {
                if(reverse)
                    l = mid + 1;
                else
                    r = mid - 1;
            }
            else {
                if(reverse)
                    r = mid - 1;
                else
                    l = mid + 1;
            }
        }
        return false;
    }
}
