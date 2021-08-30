package com.dsa.segmenttrees.i;

import java.util.ArrayList;
import java.util.Arrays;

public class KthSmallestInRange {

    private Node[] segTree; //stores sorted array list of indices at each node

    public int[] solve(int[] A, int[][] B) {
        segTree = new Node[4 * A.length];

        //convert input into Array of Pairs (value,index)
        Pair[] input = new Pair[A.length];
        for (int i = 0; i < A.length; i++) {
            Pair temp = new Pair(A[i], i);
            input[i] = temp;
        }

        //sort based on values
        Arrays.sort(input, (x, y) -> {
            Integer x1 = x.value;
            Integer y1 = y.value;
            return x1.compareTo(y1);
        });

        build(1, 0, input.length - 1, input); //build segTree based on indices not values

        int[] ans = new int[B.length];
        for (int i = 0; i < B.length; i++) {
            if ((B[i][0] == B[i][1]) && B[i][2] == 1) { //no need to query, we know the answer
                ans[i] = A[B[i][0] - 1];
            } else {
                ans[i] = A[query(1, 0, A.length - 1, B[i][0] - 1, B[i][1] - 1, B[i][2])];
            }
        }
        return ans;
    }

    private void build(int treeIndex, int start, int end, Pair[] input) {

        if (start == end) {
            segTree[treeIndex] = new Node(new ArrayList<>(Arrays.asList(input[start].index)));
            return;
        }

        int mid = start + ((end - start) / 2);

        build(2 * treeIndex, start, mid, input);
        build((2 * treeIndex) + 1, mid + 1, end, input);

        //update segTree[treeIndex] after recursion, merge two sorted array lists of indices
        segTree[treeIndex] = new Node(merge(segTree[2 * treeIndex].indexList, segTree[(2 * treeIndex) + 1].indexList));
    }

    private int query(int treeIndex, int start, int end, int rangeStart, int rangeEnd, int k) {

        if (start == end) {
            return segTree[treeIndex].indexList.get(0);
        }
        int mid = start + ((end - start) / 2);

        int p = inRange(rangeStart, rangeEnd, 2 * treeIndex); //returns count of indices in the range in left sub-tree
        if (p >= k) {
            return query(2 * treeIndex, start, mid, rangeStart, rangeEnd, k);
        } else {
            return query(2 * treeIndex + 1, mid + 1, end, rangeStart, rangeEnd, k - p);
        }
    }

    //binary search on sorted indices array to find how many of them are >= s and <= e
    private int inRange(int s, int e, int treeIndex) {
        ArrayList<Integer> indices = segTree[treeIndex].indexList;
        if (indices.size() == 1) {
            return (indices.get(0) > e || indices.get(0) < s) ? 0 : 1;
        }

        int l = 0;
        int r = indices.size() - 1;

        int startIndex = -1;
        while (l <= r) {
            int mid = l + ((r - l) / 2);
            if (indices.get(mid) >= s) {
                startIndex = mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }

        l = 0;
        r = indices.size() - 1;

        int endIndex = -1;
        while (l <= r) {
            int mid = l + ((r - l) / 2);
            if (indices.get(mid) <= e) {
                endIndex = mid;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        if ((endIndex < startIndex) || (endIndex == startIndex && (indices.get(startIndex) < s || indices.get(startIndex) > e))
                || endIndex == -1 || startIndex == -1)
            return 0;

        return endIndex - startIndex + 1;
    }

    //merge two sorted arrays
    private ArrayList<Integer> merge(ArrayList<Integer> A, ArrayList<Integer> B) {

        ArrayList<Integer> ans = new ArrayList<>();

        int aPtr = 0;//pointer to array A
        int bPtr = 0;//pointer to array B

        while (ans.size() < A.size() + B.size()) {

            //add from A when B is exhausted or A[aPtr] <= B[bPtr]
            if ((aPtr < A.size()) && (bPtr == B.size() || A.get(aPtr) <= B.get(bPtr))) {
                ans.add(A.get(aPtr++));
            }
            //add from B when A is exhausted or A[aPtr] > B[bPtr]
            if ((bPtr < B.size()) && (aPtr == A.size() || A.get(aPtr) > B.get(bPtr))) {
                ans.add(B.get(bPtr++));
            }
        }
        return ans;
    }

    static class Pair {
        int value;
        int index;

        public Pair(int v, int i) {
            this.value = v;
            this.index = i;
        }
    }

    static class Node {
        ArrayList<Integer> indexList;

        public Node(ArrayList<Integer> i) {
            this.indexList = i;
        }
    }
}

