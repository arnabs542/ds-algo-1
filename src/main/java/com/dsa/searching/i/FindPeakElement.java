package com.dsa.searching.i;

public class FindPeakElement {
    public int solve(int[] nums) {

        int l = 0;
        int r = nums.length - 1;

        while (l < r) {

            int mid =  l + (r - l) / 2;

            if (nums[mid] > nums[mid + 1]) {//graph going down
                r = mid; //mid can be peak
            } else {//graph going up
                l = mid + 1;
            }
        }
        return nums[r];
    }
}

