package com.dsa.heaps.i;

import java.util.ArrayList;
import java.util.Collections;

public class MagicianChocolates {

    private final int mod = 1000000007;

    public int nchoc(int A, ArrayList<Integer> B) {

        ArrayList<Integer> heap = build(B);

        long ans = 0L;
        for (int i = 1; i <= A; i++) {
            ans = (ans + Long.valueOf(heap.get(1))) % mod;
            heap.set(1, heap.get(1) / 2);
            percolateDown(1, heap);
        }
        return (int) ans;
    }

    //index from which we want to perculateDown
    private void percolateDown(int index, ArrayList<Integer> heap) {

        while (index > 0 && index < heap.size()) {

            int leftIndex = 2 * index;
            int rightIndex = 2 * index + 1;

            int left = leftIndex < heap.size() ? heap.get(leftIndex) : Integer.MAX_VALUE;
            int right = rightIndex < heap.size() ? heap.get(rightIndex) : Integer.MAX_VALUE;

            if (heap.get(index) >= left && heap.get(index) >= right) {
                break;
            }

            int largerChildIndex = left > right ? leftIndex : rightIndex;

            Collections.swap(heap, index, largerChildIndex);
            index = largerChildIndex;
        }
    }

    //index from which we want to perculateUp
    private void percolateUp(int index, ArrayList<Integer> heap) {

        while (index > 1) {

            int parentIndex = (index) / 2;

            if (heap.get(index) <= heap.get(parentIndex)) {
                break;
            }

            Collections.swap(heap, index, parentIndex);
            index = parentIndex;
        }
    }

    private void insert(int n, ArrayList<Integer> heap) {
        if (heap == null) {
            heap = new ArrayList<>();
        }
        heap.add(n);
        percolateUp(heap.size() - 1, heap);
    }

    private ArrayList<Integer> build(ArrayList<Integer> input) {
        input.add(0, Integer.MIN_VALUE);
        for (int i = input.size() - 1; i > 0; i--) {
            percolateDown(i, input);
        }
        return input;
    }
}
/*
Magician and Chocolates
Problem Description

Given N bags, each bag contains Bi chocolates. There is a kid and a magician. In one unit of time, kid chooses a random bag i, eats Bi chocolates, then the magician fills the ith bag with floor(Bi/2) chocolates.

Find the maximum number of chocolates that kid can eat in A units of time.

NOTE:

floor() function returns the largest integer less than or equal to a given number.
Return your answer modulo 109+7


Problem Constraints
1 <= N <= 100000
0 <= B[i] <= INT_MAX
0 <= A <= 105



Input Format
First argument is an integer A.
Second argument is an integer array B of size N.



Output Format
Return an integer denoting the maximum number of chocolates that kid can eat in A units of time.



Example Input
Input 1:

 A = 3
 B = [6, 5]
Input 2:

 A = 5
 b = [2, 4, 6, 8, 10]


Example Output
Output 1:

 14
Output 2:

 33


Example Explanation
Explanation 1:

 At t = 1 kid eats 6 chocolates from bag 0, and the bag gets filled by 3 chocolates.
 At t = 2 kid eats 5 chocolates from bag 1, and the bag gets filled by 2 chocolates.
 At t = 3 kid eats 3 chocolates from bag 0, and the bag gets filled by 1 chocolate.
 so, total number of chocolates eaten are 6 + 5 + 3 = 14
Explanation 2:

 Maximum number of chocolates that can be eaten is 33.

 */