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
