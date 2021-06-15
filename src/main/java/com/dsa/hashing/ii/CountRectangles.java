package com.dsa.hashing.ii;

import java.util.HashSet;
import java.util.Objects;

public class CountRectangles {
    public int solve(int[] A, int[] B) {

        HashSet<Pair<Integer, Integer>> set = new HashSet<>();
        for (int i = 0; i < A.length; i++) {
            set.add(new Pair<>(A[i], B[i])); //add all points to set
        }
        int ans = 0;
        for (int i = 0; i < A.length; i++) {
            for (int j = i + 1; j < A.length; j++) { //for every two points of one diagonal1, consider other two points of diagonal2
                Pair<Integer, Integer> p1 = new Pair<>(A[i], B[j]); //diagonal2 point1
                Pair<Integer, Integer> p2 = new Pair<>(A[j], B[i]); //diagonal2 point2

                if (A[i] != A[j] && B[i] != B[j]) { //other two points shouldn't turn out to be same as points under consideration
                    //check if points can be of diagonal1 then if p1 and p2 exist in the set
                    if (set.contains(p1) && set.contains(p2)) {
                        ans++;
                    }
                }
            }
        }
        return ans / 2; //take half, because we count each rectangle twice because of two diagonals
    }

    static class Pair<T, E> {
        T x;
        E y;

        Pair(T x, E y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Pair<?, ?> pair = (Pair<?, ?>) o;
            return Objects.equals(x, pair.x) &&
                    Objects.equals(y, pair.y);
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }
}
/*
Count Rectangles
Problem Description

Given two arrays of integers A and B of size N each, where each pair (A[i], B[i]) for 0 <= i < N represents a unique point (x, y) in 2-D Cartesian plane.

Find and return the number of unordered quadruplet (i, j, k, l) such that (A[i], B[i]), (A[j], B[j]), (A[k], B[k]) and (A[l], B[l]) form a rectangle with the rectangle having all the sides parallel to either x-axis or y-axis.



Problem Constraints
1 <= N <= 2000
0 <= A[i], B[i] <= 109



Input Format
The first argument given is the integer array A.
The second argument given is the integer array B.



Output Format
Return the number of unordered quadruplet that form a rectangle.



Example Input
Input 1:

 A = [1, 1, 2, 2]
 B = [1, 2, 1, 2]
Input 1:

 A = [1, 1, 2, 2, 3, 3]
 B = [1, 2, 1, 2, 1, 2]


Example Output
Output 1:

 1
Output 2:

 3


Example Explanation
Explanation 1:

 All four given points make a rectangle. So, the answer is 1.
Explanation 2:

 3 quadruplets which make a rectangle are: (1, 1), (2, 1), (2, 2), (1, 2)
                                           (1, 1), (3, 1), (3, 2), (1, 2)
                                           (2, 1), (3, 1), (3, 2), (2, 2)

 */