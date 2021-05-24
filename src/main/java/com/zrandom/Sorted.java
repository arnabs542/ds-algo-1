package com.zrandom;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Sorted {

    private static final int p = 1000003;
    private static long[] fact;
    private static int[] ranks;

    private static void constructFactorialArray(int n) {
        fact = new long[n + 1];
        fact[0] = 1;
        for (int i = 1; i <= n; i++)
            fact[i] = (fact[i - 1] * i) % p;
    }

    private static List<Character> distinctCharsBefore(char c) {
        List<Character> chars = new ArrayList<>();
        int ans = 0;
        for (int i = 0; i < (int) c; i++) {
            if (ranks[i] > 0) {
                chars.add((char) i);
            }
        }
        return chars;
    }

    public static long getDenomProd(char c) {
        long prod = 1L;
        for (int i = 0; i < ranks.length; i++) {
            if (ranks[i] > 1) {
                if (i != (int) c) {
                    prod *= fact[ranks[i]];
                } else {
                    prod *= fact[ranks[i] - 1];
                }
            }
        }
        return prod;
    }

    public static int findRank(String A) {

        int length = A.length();
        ranks = new int[256];

        constructFactorialArray(length);

        for (int i = 0; i < length; i++) {
            ranks[A.charAt(i)]++;
        }
        int sum = 0;
        for (int i = 0; i < length; i++) {

            for (Character c : distinctCharsBefore(A.charAt(i))) {
                int rem = length - i - 1;
                long num = fact[rem];
                long denom = getDenomProd(c);

                long prod = num / denom;

                sum += prod;
            }

            ranks[A.charAt(i)]--;
        }

        return (sum + 1) % p;
    }

    public static void main(String[] args) {

        int[] count = new int[]{80, 4, 83, 93, 88, 30, 31, 6, 97, 15, 5, 25, 27, 80, 12, 55, 18, 52, 95, 54, 14, 96, 86, 5, 61, 79, 60, 66, 48, 48, 14,
                52, 81, 63, 84, 69, 46, 61, 43, 2, 16, 72, 64, 59, 56, 23, 67, 97, 5, 39, 37, 32, 19, 50, 48, 64, 10, 83, 29, 100};

        int[] a = new int[]{48, 45, -3, 7, -25, 38, 2, 13, 13, 18, -44, 34, -27, -46, 48, -39, -41, -32, -16, 17, -6, 44, -28, -44, -6, -43, -16, 30, -3, -27, 32, 38, -26, 20, 4, -44, -37};
        int[] b = new int[]{47, -42, 41, 22, -4, -35, -45, -22, 5, -20, 21, -13, 47, 32, -48, 47, 17, -23, 30, -30, 37, 42, 44, 23, 1, -40, -9, 34, -34, 49, 16, -35, 2, -19, 31, 23, -37};

        double de = Math.pow(10, 15);
        System.out.println(de);

        int[] ar = new int[]{66, 96, 43, 28, 14, 1, 41, 76, 70, 81, 22, 11, 42, 78, 4, 88, 70, 43, 90, 6, 12};
        ArrayList<Integer> list = IntStream.of(ar)
                .boxed().collect(Collectors.toCollection(ArrayList::new));


        TreeMap<Integer, Integer> ok = new TreeMap<>();
    }

    static class Pair<T, U> {
        T x;
        U y;

        public Pair(T x, U y) {
            this.x = x;
            this.y = y;
        }
    }

}



















