package com.dsa.greedy.i;

public class BinaryStrings {
    public int solve(String A, int B) {

        int[] flags = new int[A.length()]; //stores no. of flips of each bit
        int sum = 0;

        for (int i = 0; i < A.length(); i++) {

            //if no. of flips is even and bit is '1', no need to flip
            //if no. of flips is odd and bit is '0', no need to flip
            if ((A.charAt(i) == '1' && flags[i] % 2 == 0)
                    || (A.charAt(i) == '0' && flags[i] % 2 == 1)) {
                continue;
            }
            sum++; //need to flip, so increment sum
            if (i + B > A.length()) //no window of B is left, but need too flip, so not possible
                return -1;

            for (int j = 0; j < B; j++) //update flags count in the current window of length B
                flags[i + j]++;
        }
        return sum;
    }
}
