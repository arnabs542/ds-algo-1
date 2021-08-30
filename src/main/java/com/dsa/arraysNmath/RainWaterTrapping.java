package com.dsa.arraysNmath;

public class RainWaterTrapping {

    public int trap(final int[] A) {

        int left = 0;
        int right = A.length - 1;
        int sum = 0;
        int maxLeft = 0, maxRight = 0;

        while (left < right) {

            // When height of left side is lower, calculate height of water trapped in left bin else calculate for right bin
            if (A[left] < A[right]) {
                if (A[left] > maxLeft)
                    maxLeft = A[left];
                else
                    sum += maxLeft - A[left];
                left++;
            } else {
                if (A[right] > maxRight)
                    maxRight = A[right];
                else
                    sum += maxRight - A[right];
                right--;
            }
        }
        return sum;

//        int[] prefix = new int[A.length];
//        int[] postfix = new int[A.length];
//
//        int leftMax = A[0];
//        for (int i = 1; i < A.length; i++) {
//            if (A[i] > leftMax) {
//                leftMax = A[i];
//            }
//            prefix[i] = leftMax;
//        }
//
//        int rightMax = A[A.length - 1];
//        for (int i = A.length - 2; i >= 0; i--) {
//            if (A[i] > rightMax) {
//                rightMax = A[i];
//            }
//            postfix[i] = rightMax;
//        }
//
//        //calculate Min(Lmax-Rmax) - A[i]
//        int sum = 0;
//        for (int i = 1; i < A.length - 1; i++) {
//            sum += Math.min(postfix[i], prefix[i]) - A[i];
//        }
//
//        return sum;
    }
}

