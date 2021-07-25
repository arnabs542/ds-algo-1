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
/*
Special Sums
Problem Description

You are given an array A of size N.

You need to process Q queries of following types on it:

X val, change the value of the Xth element of array A to val.
L R, find the sum: 1*a[L] + 2*a[L+1] + . . . + (R-L+1)*a[R].
Since, the result can be large, print it modulo 109 + 7



Problem Constraints
1 ≤ N, Q ≤ 105
1 ≤ A[i] ≤ 105
For query of the 1st type,

1 ≤ X ≤ N
1 ≤ val ≤ 105
For query of the 2nd type,

1 ≤ L ≤ R ≤ N


Input Format
The first argument of the input is the array A.

The second argument of the input is a 2-D array B containing the description of the queries.

Each query is an array of 3 elements, representing either (1 X val) or (2 L R).



Output Format
Return an array of answers to each query of the 2nd type, in the same order they were asked in the input.



Example Input
Input 1:

A: [2, 1, 4, 3]
B:  [
        [2, 1, 3],
        [1, 2, 5],
        [2, 1, 3]
    ]
Input 2:

A: [5, 6, 3, 7, 9]
B:  [
        [2, 1, 5],
        [2, 3, 4],
        [1, 3, 7],
        [2, 2, 4]
    ]


Example Output
Output 1:

[16, 24]
Output 2:

[99, 17, 41]


Example Explanation
Explanation 1:


For the 1st query, the sum is: 1*2 + 2*1 + 3*4 = 16.

After the 2nd query, the array becomes: [2, 5, 4, 3].

For the 3rd query, the sum is: 1*2 + 2*5 + 3*4 = 24.


Explanation 2:


For the 1st query, the sum is: 1*5 + 2*6 + 3*3 + 4*7 + 5*9 = 99.

For the 2nd query, the sum is: 1*3 + 2*7 = 17.

After the 3rd query, the array becomes: [5, 6, 7, 7, 9].

For the 4th query, the sum is: 1*6 + 2*7 + 3*7 = 41.

 */
