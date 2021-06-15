package com.dsa.hashing.ii;

import java.util.HashMap;

public class CountRightTriangles {
    public int solve(int[] A, int[] B) {

        HashMap<Integer, Integer> mapX = new HashMap<>();
        HashMap<Integer, Integer> mapY = new HashMap<>();

        for (int i = 0; i < A.length; i++) {
            mapX.put(A[i], mapX.getOrDefault(A[i], 0) + 1); //for each co-ordinate, count no. of points with same X co-ordinate
            mapY.put(B[i], mapY.getOrDefault(B[i], 0) + 1); //for each co-ordinate, count no. of points with same Y co-ordinate
        }
        int ans = 0;
        for (int i = 0; i < A.length; i++) {
            ans += (mapX.get(A[i]) - 1) * (mapY.get(B[i]) - 1); // -1 because need to exclude point at which right angle is formed
        }
        return ans;
    }
}
/*
Count Right Triangles
Problem Description

Given two arrays of integers A and B of size N each, where each pair (A[i], B[i]) for 0 <= i < N represents a unique point (x, y) in 2D Cartesian plane.

Find and return the number of unordered triplets (i, j, k) such that (A[i], B[i]), (A[j], B[j]) and (A[k], B[k]) form a right angled triangle with the triangle having one side parallel to the x-axis and one side parallel to the y-axis.

NOTE: The answer may be large so return the answer modulo (109 + 7).



Problem Constraints
1 <= N <= 105

0 <= A[i], B[i] <= 109



Input Format
The first argument given is an integer array A.
The second argument given is the integer array B.



Output Format
Return the number of unordered triplets that form a right angled triangle modulo (109 + 7).



Example Input
Input 1:

 A = [1, 1, 2]
 B = [1, 2, 1]
Input 2:

 A = [1, 1, 2, 3, 3]
 B = [1, 2, 1, 2, 1]


Example Output
Output 1:

 1
Output 2:

 6


Example Explanation
Explanation 1:

 All three points make a right angled triangle. So return 1.
Explanation 2:

 6 quadruplets which make a right angled triangle are: (1, 1), (1, 2), (2, 2)
                                                       (1, 1), (3, 1), (1, 2)
                                                       (1, 1), (3, 1), (3, 2)
                                                       (2, 1), (3, 1), (3, 2)
                                                       (1, 1), (1, 2), (3, 2)
                                                       (1, 2), (3, 1), (3, 2)

 */
