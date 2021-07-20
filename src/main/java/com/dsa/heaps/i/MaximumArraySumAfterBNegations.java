package com.dsa.heaps.i;

import java.util.ArrayList;
import java.util.Collections;

public class MaximumArraySumAfterBNegations {

    public int solve(ArrayList<Integer> A, int B) {

        ArrayList<Integer> minHeap = build(A); //build minHeap

        int ans = 0;
        for (int i = 1; i <= B; i++) {
            minHeap.set(1, -1 * minHeap.get(1)); //negate the min and rebuild heap
            percolateDown(1, minHeap);
        }

        //after B negations, take sum of all elems in heap
        for (int i = 1; i < minHeap.size(); i++) {
            ans += minHeap.get(i);
        }
        return ans;
    }

    //index from which we want to perculateDown
    private void percolateDown(int index, ArrayList<Integer> heap) {

        while (index > 0 && index < heap.size()) {

            int leftIndex = 2 * index;
            int rightIndex = 2 * index + 1;

            int left = leftIndex < heap.size() ? heap.get(leftIndex) : Integer.MAX_VALUE;
            int right = rightIndex < heap.size() ? heap.get(rightIndex) : Integer.MAX_VALUE;

            if (heap.get(index) <= left && heap.get(index) <= right) {
                break;
            }

            int smallerChildIndex = left < right ? leftIndex : rightIndex;

            Collections.swap(heap, index, smallerChildIndex);
            index = smallerChildIndex;
        }
    }

    //index from which we want to perculateUp
    private void percolateUp(int index, ArrayList<Integer> heap) {

        while (index > 1) {

            int parentIndex = (index) / 2;

            if (heap.get(index) >= heap.get(parentIndex)) {
                break;
            }

            if (parentIndex > 0) {
                Collections.swap(heap, index, parentIndex);
                index = parentIndex;
            }
        }
    }

    private void deleteRoot(ArrayList<Integer> heap) {
        if (heap.size() <= 1) {
            return;
        }
        Collections.swap(heap, 1, heap.size() - 1);
        heap.remove(heap.size() - 1);

        percolateDown(1, heap);
    }

    private void insert(int n, ArrayList<Integer> heap) {
        heap.add(n);
        percolateUp(heap.size() - 1, heap);
    }

    private ArrayList<Integer> build(ArrayList<Integer> input) {
        input.add(0, Integer.MAX_VALUE);
        for (int i = input.size() - 1; i > 0; i--) {
            percolateDown(i, input);
        }
        return input;
    }
}
/*
Maximum array sum after B negations
Problem Description

Given an array of integers A and an integer B. You must modify the array exactly B number of times. In single modification, we can replace any one array element A[i] by -A[i].

You need to perform these modifications in such a way that after exactly B modifications, sum of the array must be maximum.



Problem Constraints
1 <= length of the array <= 5*105
1 <= B <= 5 * 106
-100 <= A[i] <= 100



Input Format
First argument given is an integer array A.
Second argument given is an integer B.



Output Format
Return an integer denoting the maximum array sum after B modifications.



Example Input
Input 1:

 A = [24, -68, -29, -9, 84]
 B = 4
Input 2:

 A = [57, 3, -14, -87, 42, 38, 31, -7, -28, -61]
 B = 10


Example Output
Output 1:

 196
Output 2:

 362


Example Explanation
Explanation 1:

 Final array after B modifications = [24, 68, 29, -9, 84]
Explanation 2:

 Final array after B modifications = [57, -3, 14, 87, 42, 38, 31, 7, 28, 61]

 */