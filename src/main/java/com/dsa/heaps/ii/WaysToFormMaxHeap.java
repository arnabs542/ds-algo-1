package com.dsa.heaps.ii;

public class WaysToFormMaxHeap {

    private int p = 1000000007;

    public int solve(int A) {
        return (int) fun(A);
    }

    //refer class notes for derivation
    public long fun(int A) {
        if (A <= 1) {
            return 1L;
        }

        // 2^0 + 2^1 + ... + 2^(h-1) = 2^h - 1
        // Total nodes till last but one level = 2^h - 1

        int h = (int) (Math.log10(A) / Math.log10(2)); //height of the heap
        int maxPossibleInLastLevel = (int) Math.pow(2, h); //if heap is perfect, last level is fully filled
        // int 2^h = (int) Math.pow(2, h);
        int actualInLastLevel = A - (maxPossibleInLastLevel - 1); //the no. of nodes that are actually there in last level

        int l; //no. of nodes in left subtree
        if (actualInLastLevel >= (maxPossibleInLastLevel / 2)) { //if actual >= max/2, left subtree is completely filled
            l = maxPossibleInLastLevel - 1; //half of the total nodes of full complete B.T - 1 (root node)
        } else {
            l = maxPossibleInLastLevel - 1 - ((maxPossibleInLastLevel / 2) - actualInLastLevel);
        }
        int r = A - 1 - l; //no. of nodes in right subtree

        return (nCr(A - 1, l) * ((fun(l) % p * fun(r) % p) % p) % p); //choose l nodes from A-1 for left subtree
    }

    private long power(long a, long b) {
        if (b == 0L) {
            return 1L;
        } else if (a == 0L) {
            return 0L;
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
Ways to form Max Heap
Problem Description

Max Heap is a special kind of complete binary tree in which for every node the value present in that node is greater than the value present in it’s children nodes.

Find the number of distinct Max Heap can be made from A distinct integers.

In short, you have to ensure the following properties for the max heap :

Heap has to be a complete binary tree ( A complete binary tree is a binary tree in which every level, except possibly the last, is completely filled, and all nodes are as far left as possible.)
Every node is greater than all its children.
NOTE: If you want to know more about Heaps, please visit this link. Return your answer modulo 109 + 7.



Problem Constraints
1 <= A <= 100



Input Format
First and only argument is an inetegr A.



Output Format
Return an integer denoting the number of distinct Max Heap.



Example Input
Input 1:

 A = 4
Input 2:

 A = 10


Example Output
Output 1:

 3
Output 2:

 3360


Example Explanation
Explanation 1:

 Let us take 1, 2, 3, 4 as our 4 distinct integers
 Following are the 3 possible max heaps from these 4 numbers :
      4           4                     4
    /  \         / \                   / \
   3    2   ,   2   3      and        3   1
  /            /                     /
 1            1                     2
Explanation 2:

 Number of distinct heaps possible with 10 distinct integers = 3360.

 */