package com.zrandom;

import java.util.ArrayList;
import java.util.Collections;

public class Heap {

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

            int left = Integer.MIN_VALUE;
            if (leftIndex > 1 && leftIndex < heap.size()) {
                left = heap.get(leftIndex);
            }
            int right = Integer.MIN_VALUE;
            if (rightIndex > 1 && rightIndex < heap.size()) {
                right = heap.get(rightIndex);
            }

            int elem = heap.get(index);

            if (elem >= left && elem >= right) {
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
            int parent = heap.get(parentIndex);

            int elem = heap.get(index);

            if (elem <= parent) {
                break;
            }

            if (parentIndex > 0) {
                Collections.swap(heap, index, parentIndex);
                index = parentIndex;
            }
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


    static class Pair {
        int a;
        int b;


        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Pair pair = (Pair) o;

            if (a != pair.a) return false;
            return b == pair.b;
        }

        @Override
        public int hashCode() {
            int result = a;
            result = 31 * result + b;
            return result;
        }
    }
}






