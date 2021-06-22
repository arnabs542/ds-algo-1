package com.dsa.twoPointers;

public class ContainerWithMostWater {
    public int maxArea(int[] A) {
        int ans = 0;
        int l = 0;
        int r = A.length - 1;

        while (l < r) {
            int a = Math.min(A[l], A[r]); //take min among the two
            ans = Math.max(ans, (r - l) * a); //update max value, for 'a' (r-l)*a will be the max possible

            if (a == A[l]) { //if min was A[l], increment l
                l++;
            } else { //if min was A[r], decrement r
                r--;
            }
        }
        return ans;
    }
}
/*
Container With Most Water
Problem Description

Given n non-negative integers A[0], A[1], ..., A[n-1] , where each represents a point at coordinate (i, A[i]).

N vertical lines are drawn such that the two endpoints of line i is at (i, A[i]) and (i, 0).

Find two lines, which together with x-axis forms a container, such that the container contains the most water.

Note: You may not slant the container.



Problem Constraints
0 <= N <= 105

1 <= A[i] <= 105



Input Format
Single Argument representing a 1-D array A.



Output Format
Return single Integer denoting the maximum area you can obtain.



Example Input
Input 1:

A = [1, 5, 4, 3]
Input 2:

A = [1]


Example Output
Output 1:

 6
Output 2:

 0


Example Explanation
Explanation 1:


5 and 3 are distance 2 apart. So size of the base = 2. Height of container = min(5, 3) = 3.
So total area = 3 * 2 = 6
Explanation 2:


No container is formed.

 */
