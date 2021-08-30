package com.dsa.algorithm.string;

import java.util.Arrays;

public class BoringSubstring {
    public int solve(String A) {

        StringBuffer even = new StringBuffer(); //contains chars having ascii value even
        StringBuffer odd = new StringBuffer(); //contains chars having ascii value odd

        for (int i = 0; i < A.length(); i++) {
            if (A.charAt(i) % 2 == 0) {
                even.append(A.charAt(i));
            } else {
                odd.append(A.charAt(i));
            }
        }
        char[] e = even.toString().toCharArray();
        char[] o = odd.toString().toCharArray();
        Arrays.sort(e); //sort even string
        Arrays.sort(o); //sort odd string

        String es = new String(e);
        String os = new String(o);

        if (check(es + os) || check(os + es)) { //check if either of o+e or e+o is valid
            return 1;
        }
        return 0;
    }

    //checks if any two consecutive chars in s are neighbours
    private boolean check(String s) {
        for (int i = 1; i < s.length(); i++) {
            if (Math.abs(s.charAt(i) - s.charAt(i - 1)) == 1) {
                return false;
            }
        }
        return true;
    }
}
