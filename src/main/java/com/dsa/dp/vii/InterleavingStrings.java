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

