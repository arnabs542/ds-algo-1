package com.dsa.twoPointers;

public class PairsWithSum {
    public int solve(int[] A, int B) {

        int mod = 1000000007;
        long ans = 0L;

        int l = 0;
        int r = A.length - 1;

        while (l < r) {

            if (A[l] + A[r] > B) {
                r--;
            } else if (A[l] + A[r] < B) {
                l++;
            } else {

                //no. of ways of choosing two values from r-l+1 values
                if (A[l] == A[r]) {
                    ans = (ans + (Long.valueOf(r - l + 1) * Long.valueOf(r - l) / 2L) % mod) % mod;
                    break;
                }

                //to handle duplicates
                int countL = 1;
                //check till we have same elements as A[l] and increment countL++
                while (l + 1 < r && A[l + 1] == A[l]) {
                    countL++;
                    l++;
                }

                int countR = 1;
                //check till we have same elements as A[r] and increment countR++
                while (r - 1 >= l && A[r - 1] == A[r]) {
                    countR++;
                    r--;
                }

                l++;
                r--;

                ans = (ans + Long.valueOf(countL * countR) % mod) % mod; //no. of pairs = countL * countR
            }
        }
        return (int) ans;
    }
}
/*
Pairs with given sum II
Problem Description

Given a sorted array of integers (not necessarily distinct) A and an integer B, find and return how many pair of integers ( A[i], A[j] ) such that i != j have sum equal to B.

Since the number of such pairs can be very large, return number of such pairs modulo (109 + 7).



Problem Constraints
1 <= |A| <= 100000

1 <= A[i] <= 10^9

1 <= B <= 10^9



Input Format
The first argument given is the integer array A.

The second argument given is integer B.



Output Format
Return the number of pairs for which sum is equal to B modulo (10^9+7).



Example Input
Input 1:

A = [1, 1, 1]
B = 2
Input 2:


A = [1, 1]
B = 2


Example Output
Output 1:

 3
Output 2:

 1


Example Explanation
Explanation 1:

 Any two pairs sum up to 2.
Explanation 2:

 only pair (1, 2) sums up to 2.

 */