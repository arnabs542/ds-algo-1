package com.dsa.dp.i;

public class WaysToDecode {
    private final int mod = 1000000007;

    public int numDecodings(String A) {

        if (A.charAt(0) == 48) {
            return 0; //if first char is 0, no way we can decode
        }

        if (A.length() == 1) { //only 1 char, so one way
            return 1;
        }

        long[] dp = new long[A.length()]; //dp[i] represents no. of ways to represent string ending at ith index
        dp[0] = 1L;

        if (A.charAt(1) == 48 && A.charAt(0) > 50) { //no.s like 30,40,50 .... , not possible to decode
            return 0;
        }

        if (isValid2Digit(A.charAt(0), A.charAt(1))) { // no.s between 11 and 26 , are valid when taken separately and together as well
            dp[1] = 2L;
        } else {
            dp[1] = 1L;
        }

        for (int i = 2; i < A.length(); i++) {

            if (A.charAt(i) == 48 && A.charAt(i - 1) > 50) { //no.s like 30,40,50 .... , not possible to decode
                return 0;
            }

            if (A.charAt(i) == 48) { //no.s like 10,20  are valid when taken together
                dp[i] = dp[i - 2];
            } else if (isValid2Digit(A.charAt(i - 1), A.charAt(i))) { // no.s between 11 and 26 , are valid when taken separately and together as well
                dp[i] = (dp[i - 1] + dp[i - 2]) % mod;
            } else { //no.s like 27,28,29 that are valid when taken separately but not together
                dp[i] = dp[i - 1];
            }
        }
        return (int) dp[A.length() - 1];
    }

    //checks if a no. between 11 and 26 (both inclusive) can be formed
    private boolean isValid2Digit(char first, char second) {
        StringBuilder temp = new StringBuilder();
        temp.append(first);
        temp.append(second);

        int no = Integer.parseInt(temp.toString());
        return (no >= 11 && no <= 26);
    }
}

