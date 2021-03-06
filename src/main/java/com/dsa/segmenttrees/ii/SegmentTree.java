package com.dsa.segmenttrees.ii;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class SegmentTree {

    private int mod = 1000000007;
    private int[] segTree;
    private int[] segTreeDel;

    public ArrayList<Integer> solve(ArrayList<Integer> A, ArrayList<ArrayList<Integer>> B) {

        int idx = A.size() - 1; //index till which elements are filled
        ArrayList<Integer> newInput = new ArrayList<>(Arrays.asList(new Integer[B.size()]));
        Collections.fill(newInput, 0);

        ArrayList<Integer> del = new ArrayList<>(A);
        Collections.fill(del, 1);

        A.addAll(newInput);
        del.addAll(newInput);

        //Now A is of size A+B, with all 0's after A elements, as worst case there can be all appends of B
        //this way we can treat insert operation also as update
        //use another segTree for maintaining deleted indices
        segTree = new int[4 * A.size()];
        segTreeDel = new int[4 * del.size()];

        build(segTree, 1, 0, A.size() - 1, A);
        build(segTreeDel, 1, 0, A.size() - 1, del);

        ArrayList<Integer> ans = new ArrayList<>();

        for (int i = 0; i < B.size(); i++) {

            if (B.get(i).get(0) == 1) {
                idx++;
                update(segTree, 1, 0, A.size() - 1, idx, B.get(i).get(1));
                update(segTreeDel, 1, 0, del.size() - 1, idx, 1);

            } else if (B.get(i).get(0) == 2) {

                int index = queryIndex(1, 0, del.size() - 1, B.get(i).get(1)); //get actual index as we might have some deleted elements
                update(segTree, 1, 0, A.size() - 1, index, B.get(i).get(2));

            } else if (B.get(i).get(0) == 3) {

                int index = queryIndex(1, 0, del.size() - 1, B.get(i).get(1)); //get actual index as we might have some deleted elements
                update(segTree, 1, 0, A.size() - 1, index, 0);
                update(segTreeDel, 1, 0, del.size() - 1, index, 0);

            } else {

                int l = queryIndex(1, 0, del.size() - 1, B.get(i).get(1)); //get actual index as we might have some deleted elements
                int r = queryIndex(1, 0, del.size() - 1, B.get(i).get(2)); //get actual index as we might have some deleted elements
                ans.add((int) query(segTree, 1, 0, A.size() - 1, l, r));
            }
        }
        return ans;
    }

    //returns the index of kth 1 in the deleted array
    private int queryIndex(int treeIndex, int start, int end, int k) {

        if (start == end) {
            return start;
        }

        int mid = start + ((end - start) / 2);

        int onesOnLeft = segTreeDel[2 * treeIndex];
        if (onesOnLeft >= k) { //go to left subTree
            return queryIndex(2 * treeIndex, start, mid, k);
        } else { //go to right subTree
            return queryIndex(2 * treeIndex + 1, mid + 1, end, k - onesOnLeft);
        }
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
/*
Segment Tree?
Problem Description

Given an array A of size N and Q queries. Perform following queries:

1 V 0 append V in the back of array.
2 X V set A[X] = V.
3 X 0 delete A[X]. Note: All element at back of X move forward to occupy void.
4 X Y find sum in range [X, Y].
NOTE: For the query of type 4 X Y, output the sum % 109 + 7.



Problem Constraints
1 <= N,Q <= 100000

1 <= A[i],V <=100000

1 <= X,Y <= N' Where, N' is current size of array.



Input Format
First argument contains an integer array A.

Second argument contains a Q x 3 Matrix B.



Output Format
Return an integer array containing answer to all query of type 4 X Y in chronological order.



Example Input
 A = [1, 2, 5, 3, 4]
 B = [ [4, 2, 4],
       [3, 3, 0],
       [1, 6, 0],
       [4, 3, 5] ]


Example Output
 [10, 13]


Example Explanation
 First Query find sum(A[2],A[3],A[4])
 Second Query make A = [1, 2, 3, 4]
 Third Query make A = [1, 2, 3, 4, 6]
 Fourth Query find sum(A[3],A[4],A[5])

 */