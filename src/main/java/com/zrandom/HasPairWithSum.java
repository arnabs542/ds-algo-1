package com.zrandom;

public class HasPairWithSum {

    private static boolean hasPairWithSum1(int[] arr, int sum) {

        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] + arr[i] == sum) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean hasPairWithSum2(int[] arr, int sum) {

        int start = 0;
        int end = arr.length - 1;

        while (start <= end) {
            if (Math.abs(arr[start] + arr[end]) > Math.abs(sum)) {
                end--;
            } else if (Math.abs(arr[start] + arr[end]) < Math.abs(sum)) {
                start++;
            } else {
                return true;
            }
        }

        return false;
    }


    public static void main(String[] args) {
        int[] arr = new int[]{-1, -2, -3, -4, -5};

        boolean exists1 = hasPairWithSum1(arr, -8);
        boolean exists2 = hasPairWithSum2(arr, -8);

        System.out.println(exists1);
        System.out.println(exists2);
    }
}
