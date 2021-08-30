package com.dsa.segmenttrees.i;

import java.util.ArrayList;

public class PowerOf3 {

    private int[] segTree;

    public ArrayList<Integer> solve(String A, ArrayList<ArrayList<Integer>> B) {

        segTree = new int[A.length() * 4];
        build(1, 0, A.length() - 1, A);

        ArrayList<Integer> ans = new ArrayList<>();

        for (int i = 0; i < B.size(); i++) {
            if (B.get(i).get(0) == 1) {
                update(1, 0, A.length() - 1, B.get(i).get(1) - 1, -1);
                ans.add(-1);
            } else {
                ans.add(query(1, 0, A.length() - 1, B.get(i).get(1) - 1, B.get(i).get(2) - 1));
            }
        }
        return ans;
    }

    private void build(int treeIndex, int start, int end, String A) {

        if (start == end) {
            segTree[treeIndex] = A.charAt(start) - '0';
            return;
        }

        int mid = start + ((end - start) / 2);

        build(2 * treeIndex, start, mid, A);
        build((2 * treeIndex) + 1, mid + 1, end, A);

        //how to determine currentNode value, from left and right
        // nodeVal = left * (shiftedVal)  + right; (node stores value%3)
        // shifted val = 2^(end-mid)
        // check for all possible values that can come from subTrees (0,1,2), there will be a patter
        if ((end - mid) % 2 == 0) {
            segTree[treeIndex] = (segTree[2 * treeIndex] + segTree[2 * treeIndex + 1]) % 3;
        } else {
            segTree[treeIndex] = (3 - segTree[2 * treeIndex] + segTree[2 * treeIndex + 1]) % 3;
        }

    }

    private void update(int treeIndex, int start, int end, int index, int value) {

        if (start == end) {
            segTree[treeIndex] = 1;
            return;
        }

        int mid = start + ((end - start) / 2);

        if (index >= start && index <= mid) {
            update(2 * treeIndex, start, mid, index, value);
        } else {
            update((2 * treeIndex) + 1, mid + 1, end, index, value);
        }

        if ((end - mid) % 2 == 0) {
            segTree[treeIndex] = (segTree[2 * treeIndex] + segTree[2 * treeIndex + 1]) % 3;
        } else {
            segTree[treeIndex] = (3 - segTree[2 * treeIndex] + segTree[2 * treeIndex + 1]) % 3;
        }
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

            int left = query(2 * treeIndex, start, mid, rangeStart, mid);
            int right = query(2 * treeIndex + 1, mid + 1, end, mid + 1, rangeEnd);

            if ((rangeEnd - mid) % 2 == 0) {
                return (left + right) % 3;
            } else {
                return (3 - left + right) % 3;
            }
        } else if (rangeEnd <= mid) {
            return query(2 * treeIndex, start, mid, rangeStart, rangeEnd);
        } else {
            return query(2 * treeIndex + 1, mid + 1, end, rangeStart, rangeEnd);
        }
    }
}
