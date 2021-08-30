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
