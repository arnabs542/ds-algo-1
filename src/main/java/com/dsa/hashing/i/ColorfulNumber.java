package com.dsa.hashing.i;

import java.util.HashSet;

public class ColorfulNumber {
    public int colorful(int A) {

        String s = Integer.toString(A);
        HashSet<Integer> set = new HashSet<>();

        //check for subsequences of all lengths
        for (int i = 1; i <= s.length(); i++) {

            //check all subsequences of length i
            for (int right = 0; right + i <= s.length(); right++) {

                int prod = productOfDigits(s.substring(right, right + i));
                if (set.contains(prod)) {
                    return 0;
                } else {
                    set.add(prod);
                }
            }
        }
        return 1;
    }

    //returns product of digits
    private int productOfDigits(String s) {
        int ans = 1;
        for (int i = 0; i < s.length(); i++) {
            ans *= Integer.parseInt(String.valueOf(s.charAt(i)));
        }
        return ans;
    }
}
/*
Colorful Number
Problem Description

For Given Number A find if its COLORFUL number or not.

If number A is a COLORFUL number return 1 else return 0.

What is a COLORFUL Number:

A number can be broken into different contiguous sub-subsequence parts.
Suppose, a number 3245 can be broken into parts like 3 2 4 5 32 24 45 324 245.
And this number is a COLORFUL number, since product of every digit of a contiguous subsequence is different.


Problem Constraints
1 <= A <= 2 * 109



Input Format
Single Argument which denotes integer A.



Output Format
Return 1 if integer A is COLORFUL else return 0.



Example Input
Input 1:

 A = 23
Input 2:

 A = 236


Example Output
Output 1:

 1
Output 2:

 0


Example Explanation
Explanation 1:

 Possible Sub-sequences: [2, 3, 23] where
 2 -> 2
 3 -> 3
 23 -> 6  (product of digits)
 This number is a COLORFUL number since product of every digit of a sub-sequence are different.
Explanation 2:

 Possible Sub-sequences: [2, 3, 6, 23, 36, 236] where
 2 -> 2
 3 -> 3
 6 -> 6
 23 -> 6  (product of digits)
 36 -> 18  (product of digits)
 236 -> 36  (product of digits)
 This number is not a COLORFUL number since the product sequence 23  and sequence 6 is same.

 */