package com.dsa.searching.i;

public class MaximumHeightStaircase {

    public int solve(int A) {

        //1+2+3+4+....+X = X*(X+1)/2
        int l = 0;
        int r = A; //can't be greater than this, so upper limit can be fixed

        int ans = 0;
        while (l <= r) {
            int mid = l + ((r - l) / 2);

            long bricksNeeded = Long.valueOf(mid) * Long.valueOf(mid + 1L) / 2L;

            if (bricksNeeded > Long.valueOf(A)) {//you can't have mid levels, so go down
                r = mid - 1;
            } else {//you can have mid levels, but still check if can go higher than this level
                ans = mid;
                l = mid + 1;
            }
        }
        return ans;
    }
}
