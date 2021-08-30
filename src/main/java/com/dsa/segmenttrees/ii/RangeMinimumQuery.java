package com.dsa.segmenttrees.ii;

import java.util.ArrayList;

public class RangeMinimumQuery {

    private int[] segTree;

    public ArrayList<Integer> solve(ArrayList<Integer> A, ArrayList<ArrayList<Integer>> B) {

        ArrayList<Integer> ans = new ArrayList<>();

        segTree = new int[A.size() * 4];
        build(1, 0, A.size() - 1, A);

        for (int i = 0; i < B.size(); i++) {
            if (B.get(i).get(0) == 0) {
                update(1, 0, A.size() - 1, B.get(i).get(1) - 1, B.get(i).get(2));
            } else {
                ans.add(query(1, 0, A.size() - 1, B.get(i).get(1) - 1, B.get(i).get(2) - 1));
            }
        }
        return ans;
    }

    private void build(int treeIndex, int start, int end, ArrayList<Integer> A) {

        if (start == end) {
            segTree[treeIndex] = A.get(start);
            return;
        }

        int mid = start + ((end - start) / 2);

        build(2 * treeIndex, start, mid, A);
        build((2 * treeIndex) + 1, mid + 1, end, A);

        segTree[treeIndex] = Math.min(segTree[2 * treeIndex], segTree[2 * treeIndex + 1]);
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
        segTree[treeIndex] = Math.min(segTree[2 * treeIndex], segTree[(2 * treeIndex) + 1]);
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
            return Math.min(query(2 * treeIndex, start, mid, rangeStart, mid), query(2 * treeIndex + 1, mid + 1, end, mid + 1, rangeEnd));
        } else if (rangeEnd <= mid) {
            return query(2 * treeIndex, start, mid, rangeStart, rangeEnd);
        } else {
            return query(2 * treeIndex + 1, mid + 1, end, rangeStart, rangeEnd);
        }
    }
}
