package com.dsa.bitmanipulation;

public class InterestingArray {
    public String solve(int[] A) {
        //every even element can be made 0 by splitting it into two and xoring them
        //every odd element can be made 1 by writing it as 1 + some even no.
        //so if no. of odd elements are even then its possible
        int odd = 0;
        for (int i = 0; i < A.length; i++) {
            if (A[i] % 2 == 1) {
                odd++;
            }
        }
        return (odd % 2 == 0) ? "Yes" : "No";
    }
}
/*
Interesting Array
Problem Description

You have an array A with N elements. We have 2 types of operation available on this array :
We can split a element B into 2 elements C and D such that B = C + D.
We can merge 2 elements P and Q as one element R such that R = P^Q i.e XOR of P and Q.
You have to determine whether it is possible to make array A containing only 1 element i.e. 0 after several splits and/or merge?



Problem Constraints
1 <= N <= 100000

1 <= A[i] <= 106



Input Format
The first argument is an integer array A of size N.



Output Format
Return "Yes" if it is possible otherwise return "No".



Example Input
Input 1:

 A = [9, 17]
Input 2:

 A = [1]


Example Output
Output 1:

 Yes
Output 2:

 No


Example Explanation
Explanation 1:

 Following is one possible sequence of operations -
 1) Merge i.e 9 XOR 17 = 24
 2) Split 24 into two parts each of size 12
 3) Merge i.e 12 XOR 12 = 0
 As there is only 1 element i.e 0. So it is possible.
Explanation 2:

 There is no possible way to make it 0.

 */