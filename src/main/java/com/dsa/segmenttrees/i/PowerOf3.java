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
/*
Power of 3
Problem Description

Given a binary string A of size N and an integer matrix B of size Q x 3.

Matrix B has Q queries:

For queries of type B[i][0] = 1, flip the value at index B[i][1] in A if and only if the value at that index is 0 and return -1.
For queries of type B[i][0] = 0, Return the value of the binary string from index B[i][1] to B[i][2] modulo 3.
Note: Rows are numbered from top to bottom and columns are numbered from left to right.



Problem Constraints
1 <= N <= 100000
1 <= Q <= 200000
1 <= B[i][1], B[i][2] <= N
B[i][1] <= B[i][2]



Input Format
The first argument given is the string A.
The second argument given is the integer matrix B of size Q * 3.



Output Format
Return an array of size Q where ith value is answer to ith query.



Example Input
Input 1:

 A = 10010
 B = [  [0, 3, 5]
        [0, 3, 4]
        [1, 2, -1]
        [0, 1, 5]
     ]
Input 2:

 A = 11111
 B = [
        [0, 2, 4]
        [1, 2, -1
        [0, 2, 4]]
     ]


Example Output
Output 1:

 [2, 1, -1, 2]
Output 2:

 [1, -1, 1]


Example Explanation
Explanation 1:

 For query 1, binary string from index 3 to 5 is 010 = 2. So 2 mod 3 = 2.
 For query 2, binary string from index 3 to 4 is 01 = 1. So 1 mod 3 = 1.
 After query 3, given string changes to 11010.
 For query 4, binary string from index 1 to 5 is 11010 = 26. So 26 mod 3 = 2.
 So, output array is [2, 1, -1, 2].
Explanation 2:

 For query 1, binary string from index 2 to 4 is 111 = 7. So 7 od 3 = 1.
 After query 2, string remains same as there is already 1 at index 2.
 For query 3, binary string from index 2 to 4 is 111 = 7. So 7 od 3 = 1.
 So, output array is [1, -1, 1].

 */