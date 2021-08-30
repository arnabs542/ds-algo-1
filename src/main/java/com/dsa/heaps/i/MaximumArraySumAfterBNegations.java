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
