package com.dsa.dp.vii;

public class InterleavingStrings {

    public int isInterleave(String A, String B, String C) {
        return recurse(A.length() - 1, B.length() - 1, C.length() - 1, A, B, C) ? 1 : 0;
    }

    private boolean recurse(int aIndex, int bIndex, int cIndex, String A, String B, String C) {

        // all have reached end, must have matched so return true
        if (aIndex == -1 && bIndex == -1 && cIndex == -1) {
            return true;
        }

        // reached end of C but not A/B , return false
        if (cIndex == -1) {
            return false;
        }

        boolean answer = false;

        //if char in A matches C, recurse further on A
        if (aIndex >= 0 && (A.charAt(aIndex) == C.charAt(cIndex))) {
            answer |= recurse(aIndex - 1, bIndex, cIndex - 1, A, B, C);
        }

        //if char in B matches C, recurse further on B
        if (bIndex >= 0 && (B.charAt(bIndex) == C.charAt(cIndex))) {
            answer |= recurse(aIndex, bIndex - 1, cIndex - 1, A, B, C);
        }

        return answer;
    }
}
/*
Interleaving Strings
Problem Description

Given A, B, C find whether C is formed by the interleaving of A and B.



Problem Constraints
1 <= length(A), length(B) <= 100

1 <= length(C) <= 200



Input Format
The first argument of input contains a string, A.
The second argument of input contains a string, B.
The third argument of input contains a string, C.



Output Format
Return 1 if string C is formed by interleaving of A and B else 0.



Example Input
Input 1:

 A = "aabcc"
 B = "dbbca"
 C = "aadbbcbcac"
Input 2:

 A = "aabcc"
 B = "dbbca"
 C = "aadbbbaccc"


Example Output
Output 1:

 1
Output 2:

 0


Example Explanation
Explanation 1:

 "aa" (from A) + "dbbc" (from B) + "bc" (from A) + "a" (from B) + "c" (from A)
Explanation 2:

 It is not possible to get C by interleaving A and B.

 */
