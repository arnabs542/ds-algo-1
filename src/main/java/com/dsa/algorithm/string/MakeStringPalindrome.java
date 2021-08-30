package com.dsa.algorithm.string;

public class MakeStringPalindrome {
    public int solve(String A) {

        StringBuilder rev = new StringBuilder(A);
        StringBuilder original = new StringBuilder(A);
        original.append(rev.reverse()); // A appended with reverse of A

        int[] Z = getZArray(original.toString());

        for (int i = Z.length / 2; i < Z.length; i++) {
            if (Z[i] == Z.length - i) {//prefix that lasts till end starting at i
                return A.length() - Z[i];
            }
        }
        return 0;
    }

    //O(n)
    private int[] getZArray(String s) {

        int n = s.length();
        int[] z = new int[n];

        int l = 0;
        int r = 0;

        for (int i = 1; i < n; i++) {
            if (i <= r) {
                z[i] = Math.min(r - i + 1, z[i - l]); //i - l corresponds to position of char same as that at i
            } else {
                int j = 0;
                while (i + j < n && s.charAt(j) == s.charAt(i + j)) {
                    j++;
                }
                z[i] = j;
                l = i;
                r = i + j - 1;
            }
        }
        return z;
    }

    //O(n^2)
    private int[] getZArray1(String s) {

        int n = s.length();
        int[] z = new int[n];

        for (int i = 1; i < n; i++) {
            int j = 0;
            while ((i + j < n) && s.charAt(i + j) == s.charAt(j)) {
                z[i]++;
                j++;
            }
        }
        return z;
    }
}
