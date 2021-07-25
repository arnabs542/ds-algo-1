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
/*
Bob and Queries
Problem Description

Bob has an array A of N integers. Initially, all the elements of the array are zero. Bob asks you to perform Q operations on this array.

You have to perform three types of query, in each query you are given three integers x, y and z.

if x = 1: Update the value of A[y] to 2 * A[y] + 1.
if x = 2: Update the value A[y] to ⌊A[y]/2⌋ , where ⌊⌋ is Greatest Integer Function.
if x = 3: Take all the A[i] such that y <= i <= z and convert them into their corresponding binary strings. Now concatenate all the binary strings and find the total no. of '1' in the resulting string.
Queries are denoted by a 2-D array B of size M x 3 where B[i][0] denotes x, B[i][1] denotes y, B[i][2] denotes z.



Problem Constraints
1 <= N, Q <= 100000
1 <= y, z <= N
1 <= x <= 3



Input Format
The first argument has the integer A.
The second argument is a 2d matrix B, of size Q x 3, representing the queries.



Output Format
Return an array of integers where ith index represents the answer of the ith type 3 query.



Example Input
Input 1:

 A = 5
 B = [
        [1, 1, -1]
        [1, 2, -1]
        [1, 3, -1]
        [3, 1, 3]
        [3, 2, 4]
     ]
Input 2:

 A = 5
 B = [
        [1, 1, -1]
        [1, 2, -1]
        [3, 1, 3]
        [2, 1, -1]
        [3, 1, 3]
     ]


Example Output
Output 1:

 [3, 2]
Output 2:

 [2, 1]


Example Explanation
Explanation 1:

 Initial array A = [0, 0, 0, 0, 0]
 After query 1, A => [1, 0, 0, 0, 0]
 After query 2, A => [1, 1, 0, 0, 0]
 After query 3, A => [1, 1, 1, 0, 0]
 For query 4, Concatenation of Binary String between index 1 and 3 : 111. So, number of 1's = 3
 For query 5, Concatenation of Binary String between index 2 and 4 : 110. So, number of 1's = 2
 So, output array is [3, 2].
Explanation 2:

 Initial array A = [0, 0, 0, 0, 0]
 After query 1, A => [1, 0, 0, 0, 0]
 After query 2, A => [1, 1, 0, 0, 0]
 For query 3, Concatenation of Binary String between index 1 and 3 : 110. So, number of 1's = 2
 After query 4, A => [0, 1, 0, 0, 0]
 For query 5, Concatenation of Binary String between index 2 and 4 : 010. So, number of 1's = 1.
 So, output array is [2, 1].

 */