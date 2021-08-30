package com.dsa.segmenttrees.i;

import java.util.ArrayList;

public class CountPrimes {

    private int[] segTree;

    public ArrayList<Integer> solve(ArrayList<Integer> A, ArrayList<String> B,
                                    ArrayList<Integer> C, ArrayList<Integer> D) {

        //simple approach, just check if no. is prime when building segTree
        //if prime, put 1 else 0
        segTree = new int[A.size() * 4]; //segTree Nodes store the no. of primes
        build(1, 0, A.size() - 1, A);

        ArrayList<Integer> ans = new ArrayList<>();

        for (int i = 0; i < B.size(); i++) {
            if (B.get(i).equals("C")) {
                update(1, 0, A.size() - 1, C.get(i) - 1, D.get(i));
            } else {
                ans.add(query(1, 0, A.size() - 1, C.get(i) - 1, D.get(i) - 1));
            }
        }
        return ans;
    }

    private void build(int treeIndex, int start, int end, ArrayList<Integer> A) {

        if (start == end) {
            segTree[treeIndex] = isPrime(A.get(start)) ? 1 : 0;
            return;
        }

        int mid = start + ((end - start) / 2);

        build(2 * treeIndex, start, mid, A);
        build((2 * treeIndex) + 1, mid + 1, end, A);

        segTree[treeIndex] = segTree[2 * treeIndex] + segTree[2 * treeIndex + 1];
    }

    private void update(int treeIndex, int start, int end, int index, int value) {

        if (start == end) {
            segTree[treeIndex] = isPrime(value) ? 1 : 0;
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

    private boolean isPrime(int N) {
        for (int i = 2; i * i <= N; i++) {
            if (N % i == 0) {
                return false;
            }
        }
        return true;
    }
}

