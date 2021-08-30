package com.dsa.segmenttrees.i;

import java.util.ArrayList;

public class SpecialSums {

    private int mod = 1000000007;

    public ArrayList<Integer> solve(ArrayList<Integer> A, ArrayList<ArrayList<Integer>> B) {

        //refer class notes for mathematical simplification
        int[] segTreeA = new int[4 * A.size()]; //stores A[i] at leaves
        int[] segTreeB = new int[4 * A.size()]; //stores i*A[i] at leaves

        ArrayList<Integer> modifiedA = new ArrayList<>();
        for (int i = 0; i < A.size(); i++) {
            long val = (Long.valueOf(i) * Long.valueOf(A.get(i))) % mod;
            modifiedA.add((int) val);
        }

        //build both segTrees
        build(segTreeA, 1, 0, A.size() - 1, A);
        build(segTreeB, 1, 0, A.size() - 1, modifiedA);

        ArrayList<Integer> ans = new ArrayList<>();
        for (int i = 0; i < B.size(); i++) {

            if (B.get(i).get(0) == 1) {//update segTrees

                update(segTreeA, 1, 0, A.size() - 1, B.get(i).get(1) - 1, B.get(i).get(2)); //update segTreeA
                long val = (Long.valueOf(B.get(i).get(1) - 1) * Long.valueOf(B.get(i).get(2))) % mod;
                update(segTreeB, 1, 0, A.size() - 1, B.get(i).get(1) - 1, (int) val); //update segTreeB with corresponding i*A[i] value

            } else { //query segTrees
                int L = B.get(i).get(1) - 2;
                long a = query(segTreeA, 1, 0, A.size() - 1, B.get(i).get(1) - 1, B.get(i).get(2) - 1);
                long b = query(segTreeB, 1, 0, A.size() - 1, B.get(i).get(1) - 1, B.get(i).get(2) - 1);

                long answer = (b - (Long.valueOf(L) * a) % mod + Long.valueOf(mod)) % mod;
                ans.add((int) answer);
            }
        }
        return ans;
    }

    private void build(int[] segTree, int treeIndex, int start, int end, ArrayList<Integer> A) {

        if (start == end) {
            segTree[treeIndex] = A.get(start);
            return;
        }

        int mid = start + ((end - start) / 2);

        build(segTree, 2 * treeIndex, start, mid, A);
        build(segTree, (2 * treeIndex) + 1, mid + 1, end, A);

        segTree[treeIndex] = (segTree[2 * treeIndex] + segTree[2 * treeIndex + 1]) % mod;
    }

    private void update(int[] segTree, int treeIndex, int start, int end, int index, int value) {

        if (start == end) {
            segTree[treeIndex] = value;
            return;
        }

        int mid = start + ((end - start) / 2);

        if (index >= start && index <= mid) {
            update(segTree, 2 * treeIndex, start, mid, index, value);
        } else {
            update(segTree, (2 * treeIndex) + 1, mid + 1, end, index, value);
        }
        segTree[treeIndex] = (segTree[2 * treeIndex] + segTree[2 * treeIndex + 1]) % mod;
    }

    private long query(int[] segTree, int treeIndex, int start, int end, int rangeStart, int rangeEnd) {

        if (rangeStart <= start && rangeEnd >= end) {
            return Long.valueOf(segTree[treeIndex]);
        }

        if (rangeStart > end || rangeEnd < start || start > end) {
            return 0L;
        }

        int mid = start + ((end - start) / 2);

        if (rangeStart <= mid && rangeEnd > mid) {
            return (query(segTree, 2 * treeIndex, start, mid, rangeStart, mid) + query(segTree, 2 * treeIndex + 1, mid + 1, end, mid + 1, rangeEnd)) % mod;
        } else if (rangeEnd <= mid) {
            return query(segTree, 2 * treeIndex, start, mid, rangeStart, rangeEnd);
        } else {
            return query(segTree, (2 * treeIndex) + 1, mid + 1, end, rangeStart, rangeEnd);
        }
    }
}

