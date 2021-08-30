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
