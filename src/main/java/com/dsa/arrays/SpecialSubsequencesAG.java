package com.dsa.arrays;

public class SpecialSubsequencesAG {
    public int solve(String A) {

        char[] c = A.toCharArray();

        int noOfAs = 0;
        int count = 0;

        // first count no. of A's till a G is encountered
        // once G is encountered, total possible AG subsequences will be no. of A's till that G, so add no. of A's to the answer
        // repeat above steps
        for (int i = 0; i < c.length; i++) {
            if (c[i] == 'A') {
                noOfAs++;
            } else if (c[i] == 'G') {
                count += noOfAs;
            }
        }
        return count;
    }
}
