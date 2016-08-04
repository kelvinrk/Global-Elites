package com.charles.elites.lintcode;

/**
 * Created by Kelvin.R.K on 7/18/2016.
 */
public class Heapify {
    public static void main(String[] args) {
        int[] a = {5, 9, 10, 2, 3, 1};
//        int[] a = {3,2,1,4,5};
        new Heapify().heapify(a);
        for(int i : a)
            System.out.print(i + " ");
    }

    public void heapify(int[] A) {
        for (int i = A.length / 2; i >= 0; i--) {
//            helper(A, i);
            shiftDown(A, i);
        }
    }

    void helper(int[] A, int i) {
        System.out.println("i = " + i);
        int left = i * 2 + 1 >= A.length ? Integer.MAX_VALUE : A[2*i+1];
        int right = i * 2 + 2 >= A.length ? Integer.MAX_VALUE : A[2*i+2];

        if (left < right && left < A[i]) {
            A[2*i+1] = A[i];
            A[i] = left;
            helper(A, 2*i+1);
        } else if (right < A[i]) {
            A[2*i+2] = A[i];
            A[i] = right;
            helper(A, 2*i+2);
        }
    }

    private void shiftDown(int[] A, int i) {
        while (i < A.length) {
            int smallest = i;
            if (i * 2 + 1 < A.length && A[i * 2 + 1] < A[smallest]) {
                smallest = i * 2 + 1;
            }
            if (i * 2 + 2 < A.length && A[i * 2 + 2] < A[smallest]) {
                smallest = i * 2 + 2;
            }
            if (smallest == i) {
                break;
            }
            int temp = A[smallest];
            A[smallest] = A[i];
            A[i] = temp;

            i = smallest;
        }
    }
}
