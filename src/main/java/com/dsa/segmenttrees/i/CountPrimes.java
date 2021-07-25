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
/*
Count the primes
Problem Description

Given an array A, containing positive integers. You need to perform some queries on it.

You will be given Q Queries. Each query will have one string and two integers. Each Query can be of two type :

"C" X Y - Here "C" says that we need to Change the integer at position X to integer Y.
"A" X Y - Here "A" say that we are Asked number of primes in the the range : [X, Y] (inclusive)
For each Query of type 2, you need to calculate an integer denoting the answer to it.

NOTE:

Assume 1-indexing for all queries.
Your code will be run on multiple test cases (< 10). Make sure to come up with an optimised solution and take care of clearing global variables.


Problem Constraints
1 <= Size of A <= 4 * 104

1 <= A[i] <= 106

1 <= Number of Queries (Size of B, C, D) <= 5 * 104



Input Format
First argument is an integer array A.
Second argument is a string array B.
Third argument is an integer array C.
Fourth argument is an integer array D.

In the i-th query, B[i] dentotes the string, C[i] denotes X and D[i] denotes Y.



Output Format
Return an integer array, where each of the element represents the answer to the queries of type 2, in chronological order.



Example Input
Input 1:

 A = [1, 3, 121, 20, 17, 26, 29]
 B = ["A", "C", "A"]
 C = [1, 3,  1]
 D = [7, 19, 7]
Input 2:

 A = [7, 15, 11]
 B = ["C", "A"]
 C = [2, 2]
 D = [9, 3]


Example Output
Output 1:

 [3, 4]
Input 2:

 [1]


Example Explanation
Explanation 1:

 Given array A = [1, 3, 121, 20, 17, 26, 29]. Let's list down queries:
 1. A 1 7 :  Number of primes in complete array [1-7] is 3 => 3, 17, 29
 2. C 3 19 : Change the number at index-3 to 19. So Array becomes : [1, 3, 19, 20, 17, 26, 29]
 3. A 1 7 : Number of primes in complete array [1-7] is 4 => 3, 19, 17, 29
 So output : [3, 4]
Explanation 2:

 Given array A = [7, 15, 11]. Let's list down queries:
 1. C 2 9 :  Change the number at index-2 to 9. So Array becomes : [7, 9, 11]
 2. A 2 3 : Number of primes in array [2 - 3] is 1 => 11
 So output : [1]

 */
