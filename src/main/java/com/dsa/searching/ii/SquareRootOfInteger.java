package com.dsa.searching.ii;

public class SquareRootOfInteger {

    public int sqrt(int A) {

        //As 1 <= A <= 10^9
        int l = 0;
        int r = A / 2 + 1; //as A*A will exceed A, its more than sufficient to search till A

        int ans = 0;
        while (l <= r) {
            int mid = l + (r - l) / 2;

            if (Long.valueOf(mid) * Long.valueOf(mid) <= Long.valueOf(A)) { //mid can be ans, but still check for much more closer value
                l = mid + 1;
                ans = mid;
            } else {
                r = mid - 1;
            }
        }
        return ans;
    }
}
/*
Square Root of Integer
Problem Description

Given an integer A.

Compute and return the square root of A.

If A is not a perfect square, return floor(sqrt(A)).

DO NOT USE SQRT FUNCTION FROM STANDARD LIBRARY.

NOTE: Do not use sort function from standard library. Users are expected to solve this in O(log(A)) time.



Problem Constraints
0 <= A <= 1010



Input Format
The first and only argument given is the integer A.



Output Format
Return floor(sqrt(A))



Example Input
Input 1:

 11
Input 2:

 9


Example Output
Output 1:

 3
Output 2:

 3


Example Explanation
Explanation:

 When A = 11 , square root of A = 3.316. It is not a perfect square so we return the floor which is 3.
 When A = 9 which is a perfect square of 3, so we return 3.

 */