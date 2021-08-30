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
