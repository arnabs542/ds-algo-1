package com.dsa.sorting.i;

public class KthSmallestElement {
    // DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY
    public int kthsmallest(final int[] A, int B) {

        int l = Integer.MAX_VALUE;
        int r = Integer.MIN_VALUE;
        for (int i = 0; i < A.length; i++) {
            l = Math.min(l, A[i]);
            r = Math.max(r, A[i]);
        }
        int ans = -1;
        //binary search
        while (l <= r) {

            int mid = l + ((r - l) / 2);
            int count = countLesserEqual(mid, A);

            if (count >= B) {
                ans = mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return ans;
    }

    private int countLesserEqual(int k, int[] A) {
        int count = 0;
        for (int i = 0; i < A.length; i++) {
            if (A[i] <= k) {
                count++;
            }
        }
        return count;
    }
}
/*
Kth Smallest Element
Problem Description

Find the Bth smallest element in given array A .

NOTE: Users should try to solve it in <= B swaps.



Problem Constraints
1 <= |A| <= 100000

1 <= B <= min(|A|, 500)

1 <= A[i] <= 109



Input Format
First argument is vector A.

Second argument is integer B.



Output Format
Return the Bth smallest element in given array.



Example Input
Input 1:

A = [2, 1, 4, 3, 2]
B = 3
Input 2:

A = [1, 2]
B = 2


Example Output
Output 1:

 2
Output 2:

 2


Example Explanation
Explanation 1:

 3rd element after sorting is 2.
Explanation 2:

 2nd element after sorting is 2.

 */
