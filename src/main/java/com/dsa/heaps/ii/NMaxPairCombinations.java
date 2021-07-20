package com.dsa.heaps.ii;

import java.util.*;

public class NMaxPairCombinations {

    public ArrayList<Integer> solve(ArrayList<Integer> A, ArrayList<Integer> B) {

        Collections.sort(A);
        Collections.sort(B);

        Comparator<Pair<Integer, Integer, Integer>> customComparator
                = (p1, p2) -> (p2.sumValue).compareTo(p1.sumValue);

        //max sum possible with last elements, after sorting
        Pair<Integer, Integer, Integer> max = new Pair<>(A.get(A.size() - 1) + B.get(B.size() - 1),
                A.size() - 1, B.size() - 1);

        PriorityQueue<Pair<Integer, Integer, Integer>> maxHeap = new PriorityQueue<>(customComparator);
        maxHeap.add(max); //add the max possible pair to heap

        //to avoid processing already considered pairs, we store a hashset
        HashSet<Pair<Integer, Integer, Integer>> visitedPairs = new HashSet<>();
        visitedPairs.add(max);

        ArrayList<Integer> ans = new ArrayList<>();

        while (ans.size() < A.size()) {
            Pair<Integer, Integer, Integer> currMax = maxHeap.poll();
            ans.add(currMax.sumValue);

            //next possibilities of max sum of two pairs
            //one possibility is pair of (currMax.aIndex, currMax.bIndex - 1)
            //another possibility is pair of (currMax.aIndex - 1, currMax.bIndex)
            if (currMax.bIndex - 1 >= 0) {
                Pair<Integer, Integer, Integer> one = new Pair<>(A.get(currMax.aIndex) + B.get(currMax.bIndex - 1),
                        currMax.aIndex, currMax.bIndex - 1);
                if (!visitedPairs.contains(one)) {
                    maxHeap.add(one);
                    visitedPairs.add(one);
                }
            }

            if (currMax.aIndex - 1 >= 0) {
                Pair<Integer, Integer, Integer> two = new Pair<>(A.get(currMax.aIndex - 1) + B.get(currMax.bIndex),
                        currMax.aIndex - 1, currMax.bIndex);
                if (!visitedPairs.contains(two)) {
                    maxHeap.add(two);
                    visitedPairs.add(two);
                }
            }
        }
        return ans;
    }

    static class Pair<T, U, V> {
        T sumValue;
        U aIndex;
        V bIndex;

        public Pair(T sumValue, U aIndex, V bIndex) {
            this.sumValue = sumValue;
            this.aIndex = aIndex;
            this.bIndex = bIndex;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Pair<?, ?, ?> pair = (Pair<?, ?, ?>) o;

            if (!aIndex.equals(pair.aIndex)) return false;
            return bIndex.equals(pair.bIndex);
        }

        @Override
        public int hashCode() {
            int result = aIndex.hashCode();
            result = 31 * result + bIndex.hashCode();
            return result;
        }
    }
}
/*
N max pair combinations
Problem Description

Given two integers arrays A and B of size N each.

Find the maximum N elements from the sum combinations (Ai + Bj) formed from elements in array A and B.



Problem Constraints
1 <= N <= 2 * 105

-1000 <= A[i], B[i] <= 1000



Input Format
First argument is an integer array A.
Second argument is an integer array B.



Output Format
Return an integer array denoting the N maximum element in descending order.



Example Input
Input 1:

 A = [1, 4, 2, 3]
 B = [2, 5, 1, 6]
Input 2:

 A = [2, 4, 1, 1]
 B = [-2, -3, 2, 4]


Example Output
Output 1:

 [10, 9, 9, 8]
Output 2:

 [8, 6, 6, 5]


Example Explanation
Explanation 1:

 4 maximum elements are 10(6+4), 9(6+3), 9(5+4), 8(6+2).
Explanation 2:

 4 maximum elements are 8(4+4), 6(4+2), 6(4+2), 5(4+1).

 */