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
/*
Binary updates
Problem Description

Given an integer A denoting the size of the array consisting all ones.

You are given Q queries, for each query there are two integer x and y:

If x is 0, then update the value of array at index y to 0.
If x is 1, then output the index of yth one in the array. If there is no such index then output -1.
NOTE 1: There will atleast 1 query where value of x is 1.



Problem Constraints
1 <= A, Q <= 105

0 <= x <= 1

1 <= y <= A



Input Format
First argument is an integer A denoting the size of array.

Second argument is a 2-D array B of size Q x 2 where B[i][0] denotes x and B[i][1] denotes y.



Output Format
Return an integer array denoting the output of each query where x is 1.



Example Input
Input 1:

 A = 4
 B = [ [1, 2],
       [0, 2],
       [1, 4] ]
Input 2:

 A = 5
 B = [ [0, 3],
       [1, 4],
       [0, 3],
       [1, 5] ]


Example Output
Output 1:

 [2, -1]
Output 2:

 [5, -1]


Example Explanation
Explanation 1:

 Initially array = [1, 1, 1, 1]. For first query 2nd one is at index 2.
 After Second query array becomes [1, 0, 1, 1].
 For third query there is no 4th one.
Explanation 2:

 Initially array = [1, 1, 1, 1, 1]. After first query array becomes [1, 1, 0, 1, 1].
 For second query 4th one is at index 5.
 After third query array remains same [1, 1, 0, 1, 1].
 For fourth query there is no 5th one.

 */
