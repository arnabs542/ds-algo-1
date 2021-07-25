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
/*
Range Minimum Query
Problem Description

Given an integer array A of size N.

You have to perform two types of query, in each query you are given three integers x,y,z.

If x = 0, then update A[y] = z.
If x = 1, then output the minimum element in the array A between index y and z inclusive.
Queries are denoted by a 2-D array B of size M x 3 where B[i][0] denotes x, B[i][1] denotes y, B[i][2] denotes z.



Problem Constraints
1 <= N, M <= 105

1 <= A[i] <= 109

If x = 0, 1<= y <= N and 1 <= z <= 109

If x = 1, 1<= y <= z <= N



Input Format
First argument is an integer array A of size N.

Second argument is a 2-D array B of size M x 3 denoting queries.



Output Format
Return an integer array denoting the output of each query where value of x is 1.



Example Input
Input 1:

 A = [1, 4, 1]
 B = [
        [1, 1, 3]
        [0, 1, 5]
        [1, 1, 2]
     ]
Input 2:

 A = [5, 4, 5, 7]
 B = [
        [1, 2, 4]
        [0, 1, 2]
        [1, 1, 4]
     ]


Example Output
Output 1:

 [1, 4]
Output 2:

 [4, 2]


Example Explanation
Explanation 1:

 For 1st query, the minimum element from range (1, 3) is 1.
 For 2nd query, update A[1] = 5, now A = [5, 4, 1].
 For 3rd query, the minimum element from range (1, 2) is 4.
Explanation 2:

 For 1st query, the minimum element from range (2, 4) is 4.
 For 2nd query, update A[1] = 2, now A = [2, 4, 5, 7].
 For 3rd query, the minimum element from range (1, 4) is 2.
 */