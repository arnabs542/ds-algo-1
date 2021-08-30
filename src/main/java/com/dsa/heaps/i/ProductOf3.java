package com.dsa.heaps.i;

import java.util.ArrayList;
import java.util.Collections;

public class ProductOf3 {

    public ArrayList<Integer> solve(ArrayList<Integer> A) {

        ArrayList<Integer> ans = new ArrayList<>();

        ans.add(-1);
        if (A.size() == 1) {
            return ans;
        }

        ans.add(-1);
        if (A.size() == 2) {
            return ans;
        }

        ArrayList<Integer> minHeap = new ArrayList<>(); //minHeap of max three no.s
        minHeap.add(Integer.MAX_VALUE);

        int prod = 1;
        for (int i = 0; i < 3; i++) {
            prod *= A.get(i);
            insert(A.get(i), minHeap);
        }

        ans.add(prod);

        for (int i = 3; i < A.size(); i++) {
            insert(A.get(i), minHeap); //insert incoming element
            deleteRoot(minHeap); //remove min elem

            prod = minHeap.get(1) * minHeap.get(2) * minHeap.get(3); //remaining 3 in minHeap are largest 3 no.s
            ans.add(prod);
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

            Collections.swap(heap, index, parentIndex);
            index = parentIndex;
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

