package com.dsa.hashing.ii;

import java.util.HashMap;
import java.util.Objects;

public class CountPointsOnSameLine {
    public int solve(int[] A, int[] B) {
        int maxFreq = 0;
        HashMap<Pair, Integer> map = new HashMap<>();

        for (int i = 0; i < A.length; i++) {
            int duplicates = 1; //treat duplicates as different points
            int verticals = 0;
            for (int j = i + 1; j < A.length; j++) {
                if (A[i] == A[j]) {
                    if (B[i] == B[j]) {
                        duplicates++;
                    } else {
                        verticals++;
                    }
                } else {
                    Pair slope = new Pair(0, 0);
                    if (B[j] - B[i] != 0) {
                        int y = B[j] - B[i];
                        int x = A[j] - A[i];
                        int gcd = gcd(x, y);
                        slope = new Pair(y / gcd, x / gcd);
                    }
                    map.put(slope, map.getOrDefault(slope, 0) + 1); //no. of points that have same slope w.r.t ith point
                }
            }
            for (int slopeFreq : map.values()) {
                maxFreq = Math.max(maxFreq, slopeFreq + duplicates);
            }
            maxFreq = Math.max(verticals + duplicates, maxFreq); //if verticals and duplicates combined are more, update maxFreq
            map.clear(); //clear map for next point
        }
        return maxFreq;
    }

    private int gcd(int x, int y) {
        if (x == 0)
            return y;
        return gcd(y % x, x);
    }

    static class Pair {
        int y;
        int x;

        Pair(int y, int x) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Pair pair = (Pair) o;
            return y == pair.y && x == pair.x;
        }

        @Override
        public int hashCode() {
            return Objects.hash(y, x);
        }
    }
}
/*
Points on same line
Problem Description

Given two array of integers A and B describing a pair of (A[i], B[i]) coordinates in 2D plane. A[i] describe x coordinates of the ith point in 2D plane whereas B[i] describes the y-coordinate of the ith point in 2D plane.

Find and return the maximum number of points which lie on the same line.



Problem Constraints
1 <= (length of the array A = length of array B) <= 1000

-105 <= A[i], B[i] <= 105



Input Format
First argument is an integer array A.
Second argument is an integer array B.



Output Format
Return the maximum number of points which lie on the same line.



Example Input
Input 1:

 A = [-1, 0, 1, 2, 3, 3]
 B = [1, 0, 1, 2, 3, 4]
Input 2:

 A = [3, 1, 4, 5, 7, -9, -8, 6]
 B = [4, -8, -3, -2, -1, 5, 7, -4]


Example Output
Output 1:

 4
Output 2:

 2


Example Explanation
Explanation 1:

 The maximum number of point which lie on same line are 4, those points are {0, 0}, {1, 1}, {2, 2}, {3, 3}.
Explanation 2:

 Any 2 points lie on a same line.

 */