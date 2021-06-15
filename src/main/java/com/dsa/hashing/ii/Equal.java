package com.dsa.hashing.ii;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

public class Equal {
    public int[] equal(int[] A) {

        //key: sum, value: list of pairs
        //insertion order should be maintained, so take LinkedHashMap
        Map<Integer, ArrayList<Pair<Integer, Integer>>> map = new LinkedHashMap<>();

        for (int i = 0; i < A.length; i++) {
            for (int j = i + 1; j < A.length; j++) {
                int sum = A[i] + A[j];

                Pair<Integer, Integer> p = new Pair<>(i, j);
                ArrayList<Pair<Integer, Integer>> value = map.getOrDefault(sum, new ArrayList<>());
                value.add(p);

                map.put(sum, value);
            }
        }
        int[] ans = new int[4];
        Pair<Integer, Integer> p1 = null;
        Pair<Integer, Integer> p2 = null;

        for (Map.Entry<Integer, ArrayList<Pair<Integer, Integer>>> entry : map.entrySet()) {
            if (entry.getValue().size() > 1) { //check only when multiple pairs exist
                ArrayList<Pair<Integer, Integer>> value = entry.getValue();
                p1 = value.get(0);

                boolean found = false;
                for (int i = 1; i < value.size(); i++) {
                    p2 = value.get(i);
                    if (p1.x < p2.x && p1.y != p2.x && p1.y != p2.y) {//found satisfactory p2, so break
                        found = true;
                    }
                }
                if (found) { //found satisfactory p2, so break
                    break;
                }
            }
        }
        ans[0] = p1.x;
        ans[1] = p1.y;
        ans[2] = p2.x;
        ans[3] = p2.y;
        return ans;
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
Equal
Problem Description

Given an array A of N integers, find the index of values that satisfy P + Q = R + S, where P,Q,R & S are integers values in the array

Expected time complexity O(N2)

NOTE:

1) Return the indices `A1 B1 C1 D1`, so that
  A[A1] + A[B1] = A[C1] + A[D1]
  A1 < B1, C1 < D1
  A1 < C1, B1 != D1, B1 != C1

2) If there are more than one solutions,
   then return the tuple of values which are lexicographical smallest.

Assume we have two solutions
S1 : A1 B1 C1 D1 ( these are values of indices in the array )
S2 : A2 B2 C2 D2

S1 is lexicographically smaller than S2 if:
  A1 < A2 OR
  A1 = A2 AND B1 < B2 OR
  A1 = A2 AND B1 = B2 AND C1 < C2 OR
  A1 = A2 AND B1 = B2 AND C1 = C2 AND D1 < D2
If no solution is possible, return an empty list.



Problem Constraints
1 <= N <= 1000

0 <= A[i] <= 1000



Input Format
Single argument which is an integer array A of size N.



Output Format
Return an array of size 4 which indexes of values P,Q,R and S.



Example Input
Input 1:

 A = [3, 4, 7, 1, 2, 9, 8]
Input 2:

 A = [2, 5, 1, 6]


Example Output
Output 1:

 [0, 2, 3, 5]
Output 2:

 [0, 1, 2, 3]


Example Explanation
Explanation 1:

 A[0] + A[2] = A[3] + A[5]
 Note: indexes returned should be 0-based.
Explanation 2:

 A[0] + A[1] = A[2] + A[3]

 */