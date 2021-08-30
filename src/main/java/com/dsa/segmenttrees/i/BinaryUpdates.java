package com.dsa.segmenttrees.i;

import java.util.ArrayList;

public class BinaryUpdates {

    private int[] segTree;

    public ArrayList<Integer> solve(int A, ArrayList<ArrayList<Integer>> B) {
        segTree = new int[4 * A];
        build(1, 0, A - 1); //treeIndex always choose 1

        ArrayList<Integer> ans = new ArrayList<>();

        for (int i = 0; i < B.size(); i++) {
            if (B.get(i).get(0) == 0) {
                update(1, 0, A - 1, B.get(i).get(1) - 1, 0); //update segTree with 0
            } else {

                if (B.get(i).get(1) <= segTree[1]) //check if enough ones are there
                    ans.add(query(1, 0, A - 1, B.get(i).get(1) - 1));
                else {
                    ans.add(-1);
                }
            }
        }
        return ans;
    }

    private void build(int treeIndex, int start, int end) {

        //put the value of origArray[start] which is 1 in this case
        if (start == end) {
            segTree[treeIndex] = 1;
            return;
        }

        int mid = start + ((end - start) / 2);

        build(2 * treeIndex, start, mid);
        build((2 * treeIndex) + 1, mid + 1, end);

        segTree[treeIndex] = segTree[2 * treeIndex] + segTree[(2 * treeIndex) + 1]; //update segTree[treeIndex] after recursion
    }

    private void update(int treeIndex, int start, int end, int index, int value) {

        //update at the leaf(original array value) with value, then recursion will auto update entire segTree
        if (start == end) {
            segTree[treeIndex] = value;
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

    private int query(int treeIndex, int start, int end, int k) {

        if (start == end) {
            return start + 1;
        }

        int mid = start + ((end - start) / 2);

        int onesOnLeft = segTree[2 * treeIndex];
        if (onesOnLeft > k) { //go to left subTree
            return query(2 * treeIndex, start, mid, k);
        } else { //go to right subTree
            return query(2 * treeIndex + 1, mid + 1, end, k - onesOnLeft);
        }
    }
}

