package com.dsa.heaps.i;

import java.util.ArrayList;
import java.util.Collections;

public class ConnectRopes {

    public int solve(ArrayList<Integer> A) {

        if (A.size() == 1) {
            return A.get(0);
        }

        ArrayList<Integer> minHeap = build(A); //build minHeap

        int ans = 0;
        //choose 2 ropes of min length and join them and add that back to heap
        while (minHeap.size() > 3) {
            int min = minHeap.get(1);
            int secondMin = Math.min(minHeap.get(2), minHeap.get(3));

            ans += min + secondMin;

            //delete both these mins and insert sum of them
            deleteRoot(minHeap);
            minHeap.set(1, min + secondMin);
            percolateDown(1, minHeap);
        }
        return ans + minHeap.get(1) + minHeap.get(2); //heap will have 3 elems at last
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
            int parent = heap.get(parentIndex);

            if (heap.get(index) >= parent) {
                break;
            }

            Collections.swap(heap, index, parentIndex);
            index = parentIndex;
        }
    }

    private void insert(int n, ArrayList<Integer> heap) {
        heap.add(n);
        percolateUp(heap.size() - 1, heap);
    }

    private void deleteRoot(ArrayList<Integer> heap) {
        if (heap.size() <= 1) {
            return;
        }
        Collections.swap(heap, 1, heap.size() - 1);
        heap.remove(heap.size() - 1);

        percolateDown(1, heap);
    }

    private ArrayList<Integer> build(ArrayList<Integer> input) {
        input.add(0, Integer.MAX_VALUE);
        for (int i = input.size() - 1; i > 0; i--) {
            percolateDown(i, input);
        }
        return input;
    }
}
