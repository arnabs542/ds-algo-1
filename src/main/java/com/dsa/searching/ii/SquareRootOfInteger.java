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
