package com.dsa.segmenttrees.i;

import java.util.ArrayList;

public class BobAndQueries {

    int[] segTree;

    public ArrayList<Integer> solve(int A, ArrayList<ArrayList<Integer>> B) {

        segTree = new int[4 * A];

        ArrayList<Integer> ans = new ArrayList<>();

        for (int i = 0; i < B.size(); i++) {

            if (B.get(i).get(0) == 1) { //update segTree with 1, as this operation means increasing 1 set bit
                update(1, 0, A - 1, B.get(i).get(1) - 1, 1);
            } else if (B.get(i).get(0) == 2) { //update segTree with -1, as this operation means decreasing 1 set bit
                update(1, 0, A - 1, B.get(i).get(1) - 1, -1);
            } else {
                ans.add(query(1, 0, A - 1, B.get(i).get(1) - 1, B.get(i).get(2) - 1)); //query segTree for given range
            }
        }
        return ans;
    }

    private void update(int treeIndex, int start, int end, int index, int value) {

        //update at the leaf(original array value) with value, then recursion will auto update entire segTree
        if (start == end) {
            segTree[treeIndex] += value;
            segTree[treeIndex] = segTree[treeIndex] < 0 ? 0 : segTree[treeIndex];
            return;
        }

        int mid = start + ((end - start) / 2);

        //index lies between start and mid, go to left subTree
        if (index >= start && index <= mid) {
            update(2 * treeIndex, start, mid, index, value);
        } else {//index lies between mid+1 and end, go to right subTree
            update((2 * treeIndex) + 1, mid + 1, end, index, value);
        }
        segTree[treeIndex] = segTree[2 * treeIndex] + segTree[(2 * treeIndex) + 1]; //update segTree[treeIndex] after recursion
    }

    private int query(int treeIndex, int start, int end, int rangeStart, int rangeEnd) {

        //when segTree range is submerged in query range, simply return segTree[treeIndex]
        if (rangeStart <= start && rangeEnd >= end) {
            return segTree[treeIndex];
        }

        //invalid, return 0
        if (rangeStart > end || rangeEnd < start || start > end) {
            return 0;
        }

        int mid = start + ((end - start) / 2);

        //if query range is across mid i.e on both sides of mid
        if (rangeStart <= mid && rangeEnd > mid) {
            return query(2 * treeIndex, start, mid, rangeStart, mid) + query(2 * treeIndex + 1, mid + 1, end, mid + 1, rangeEnd);
        } else if (rangeEnd <= mid) { //query range totally to left of mid
            return query(2 * treeIndex, start, mid, rangeStart, rangeEnd);
        } else { //query range totally to right of mid
            return query(2 * treeIndex + 1, mid + 1, end, rangeStart, rangeEnd);
        }
    }
}
