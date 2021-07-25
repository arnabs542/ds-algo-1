package com.dsa.segmenttrees.i;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class DistinctNumbers {

    private int[] segTree;

    public ArrayList<Integer> solve(ArrayList<Integer> A, ArrayList<ArrayList<Integer>> B) {

        segTree = new int[4 * A.size()]; //nodes store no. of distinct numbers

        //key: endIndex, value: list of (startIndex,queryIndex)
        HashMap<Integer, ArrayList<Pair<Integer, Integer>>> map = new HashMap<>();

        for (int i = 0; i < B.size(); i++) {

            Pair<Integer, Integer> pair = new Pair<>(B.get(i).get(0), i);

            ArrayList<Pair<Integer, Integer>> values = map.getOrDefault(B.get(i).get(1), new ArrayList<>());
            values.add(pair);

            map.put(B.get(i).get(1), values);
        }

        //key: number, value: latest index of number in A
        HashMap<Integer, Integer> lastSeen = new HashMap<>();

        Integer[] ans = new Integer[B.size()];

        for (int i = 0; i < A.size(); i++) {
            if (lastSeen.get(A.get(i)) != null) { //already present, so update with 0 at prev index
                update(1, 0, A.size() - 1, lastSeen.get(A.get(i)), 0);
            }
            update(1, 0, A.size() - 1, i, 1); //update at latest index i.e i with 1
            lastSeen.put(A.get(i), i); //update lastSeen map

            //now ans all queries whose rightIndex ends at i
            for (Pair<Integer, Integer> pair : map.getOrDefault(i + 1, new ArrayList<>())) {
                ans[pair.queryIndex] = query(1, 0, A.size() - 1, pair.startIndex - 1, i);
            }
        }
        return new ArrayList<Integer>(Arrays.asList(ans));
    }

    private void update(int treeIndex, int start, int end, int index, int value) {

        if (start == end) {
            segTree[treeIndex] = value;
            return;
        }

        int mid = start + ((end - start) / 2);

        if (index >= start && index <= mid) {
            update(2 * treeIndex, start, mid, index, value);
        } else {
            update((2 * treeIndex) + 1, mid + 1, end, index, value);
        }
        segTree[treeIndex] = segTree[2 * treeIndex] + segTree[(2 * treeIndex) + 1];
    }

    private int query(int treeIndex, int start, int end, int rangeStart, int rangeEnd) {

        if (rangeStart <= start && rangeEnd >= end) {
            return segTree[treeIndex];
        }

        if (rangeStart > end || rangeEnd < start || start > end) {
            return 0;
        }

        int mid = start + ((end - start) / 2);

        if (rangeStart <= mid && rangeEnd > mid) {
            return query(2 * treeIndex, start, mid, rangeStart, mid) + query(2 * treeIndex + 1, mid + 1, end, mid + 1, rangeEnd);
        } else if (rangeEnd <= mid) {
            return query(2 * treeIndex, start, mid, rangeStart, rangeEnd);
        } else {
            return query(2 * treeIndex + 1, mid + 1, end, rangeStart, rangeEnd);
        }
    }

    static class Pair<T, U> {
        T startIndex;
        U queryIndex;

        Pair(T startIndex, U queryIndex) {
            this.startIndex = startIndex;
            this.queryIndex = queryIndex;
        }
    }
}
/*
Distinct Numbers
Problem Description

You are given an array A. You need to process Q queries on it.

Each query is of the form L R, for which you need to count the number of distinct elements in the array A[L..R].



Problem Constraints
1 ≤ length(A), Q, A[i] ≤ 105
1 ≤ L ≤ R ≤ N


Input Format
First line of the argument is the array A.

Second line of the argument is a Q x 2 grid, B containing the queires.



Output Format
Return an array of integers, the answers to the queries.



Example Input
Input 1:

A: [2, 3, 4, 2, 1]
B:  [
        [1, 3],
        [2, 4],
        [1, 5]
    ]
Input 2:

A: [4, 4, 4, 2, 2]
B:  [
        [1, 3],
        [4, 5],
        [1, 5]
    ]


Example Output
Output 1:

[3, 3, 4]
Output 2:

[1, 1, 2]


Example Explanation
Explanation 1:


For query 1, elements from 1 to 3 are, [2, 3, 4], hence 3 distinct elements.

For query 2, elements from 2 to 4 are, [3, 4, 2], hence 3 distinct elements.

For query 3, elements from 1 to 5 are, [2, 3, 4, 2, 1], hence 4 distinct elements.


Explanation 2:


For query 1, elements from 1 to 3 are, [4, 4, 4], hence 1 distinct element.

For query 2, elements from 4 to 5 are, [2, 2], hence 1 distinct element.

For query 3, elements from 1 to 5 are, [4, 4, 4, 2, 2], hence 2 distinct elements.

 */