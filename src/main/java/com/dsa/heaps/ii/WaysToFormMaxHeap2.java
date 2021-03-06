package com.dsa.heaps.ii;

import java.util.ArrayList;
import java.util.Collections;

public class WaysToFormMaxHeap2 {

    private int p = 1000000007;

    public int solve(ArrayList<Integer> A) {
        Collections.sort(A);
        if (A.get(0) == A.get(1)) { //if min elem is repeating
            return (int) fun2(A.size());
        } else {
            return (int) fun1(A.size()); //same as non-duplicate case
        }
    }

    public long fun2(int A) {
        if (A <= 1) {
            return 0L;
        }
        int h = (int) (Math.log(A) / Math.log(2));
        int maxPossibleInLastLevel = (int) Math.pow(2, h);

        int actualInLastLevel = A - (maxPossibleInLastLevel - 1);

        int l; //no. of nodes in left subtree
        if (actualInLastLevel >= (maxPossibleInLastLevel / 2)) {
            l = maxPossibleInLastLevel - 1;
        } else {
            l = maxPossibleInLastLevel - 1 - ((maxPossibleInLastLevel / 2) - actualInLastLevel);
        }
        int r = A - l - 1;

        long a = (nCr(A - 3, l - 2) * ((fun2(l) % p * fun1(r) % p) % p) % p); //duplicates in left subtree
        long b = (nCr(A - 3, l - 1) * ((fun1(l) % p * fun1(r) % p) % p) % p); //duplicates in diff. subtree
        long c = (nCr(A - 3, l) * ((fun1(l) % p * fun2(r) % p) % p) % p); //duplicates in right subtree
        return ((a + b) % p + c) % p;
    }

    //refer class notes for derivation
    //same as non-duplicate case
    public long fun1(int A) {
        if (A <= 1) {
            return 1L;
        }

        int h = (int) (Math.log(A) / Math.log(2)); //height of the heap
        int maxPossibleInLastLevel = (int) Math.pow(2, h); //if heap is perfect, last level is fully filled

        int actualInLastLevel = A - (maxPossibleInLastLevel - 1); //the no. of nodes that are actually there in last level

        int l; //no. of nodes in left subtree
        if (actualInLastLevel >= (maxPossibleInLastLevel / 2)) { //if actual >= max/2, left subtree is completely filled
            l = maxPossibleInLastLevel - 1; // 2^0 + 2^1 + ... + 2^(h-1) = 2^h
        } else {
            l = maxPossibleInLastLevel - 1 - ((maxPossibleInLastLevel / 2) - actualInLastLevel);
        }
        int r = A - l - 1; //no. of nodes in right subtree

        return (nCr(A - 1, l) * ((fun1(l) % p * fun1(r) % p) % p) % p); //choose l nodes from A-1 for left subtree
    }

    private long power(long a, long b) {
        if (b == 0L) {
            return 1L;
        } else if (a == 0L) {
            return a;
        } else if (b % 2 == 0L) {
            return power((a * a) % p, b / 2);
        } else {
            return (a * (power((a * a) % p, (b - 1) / 2) % p)) % p;
        }
    }

    private long inverseMod(long a) {
        return power(a, p - 2);
    }

    private long nCr(int n, int r) {
        // Since C(n, r) = C(n, n-r)
        if (r > n - r) { //we will only multiply till n-r, this helps in overcoming TLE as no. of computations will be reduced
            r = n - r;
        }

        long res = 1;
        // Calculate value of [n * (n-1) *---* (n-r+1)] / [r * (r-1) *----* 1]
        for (int i = 1; i <= r; ++i) {
            res = (res * (n - (i - 1))) % p;
            res = (res * inverseMod(i)) % p;
        }
        return res;
    }
}
/*
Ways to form Max Heap 2
Problem Description

Max heap is a special kind of complete binary tree in which for every node the value present in that node is greater than the value present in it???s children nodes.

Given an array A of size N consisting of N - 1 distinct elements. In other words there is exactly one element that is repeated.
It is given that the element that would repeat would be either the maximum element or the minimum element.

Find the number of structurally different Max heaps possible using all the N elements of the array i.e. Max heap of size N.

As final answer can be very large return your answer modulo 109 + 7.



Problem Constraints
1 <= N <= 1000



Input Format
First and only argument is an integer array A.



Output Format
Return an integer denoting the number of structurally different Max heaps possible modulo 109 + 7.



Example Input
Input 1:

 A = [1, 5, 5]
Input 2:

 A = [2, 2, 7]


Example Output
Output 1:

 2
Output 2:

 1


Example Explanation
Explanation 1:

 The possible max heaps using the given elements are:- First: 5 on the root. 1 as the left child of root and 5 as the right child of the root.
                5
              /   \
            1       5
 Second: 5 on the root. 5 as the left child of root and 1 as the right child of the root.
                5
              /   \
            5       1
Explanation 2:

 There is only one possible max heaps: 7 on the root. 2 as the left child of root and 2 as the right child of the root.
                7
              /   \
            2       2

 */