package com.dsa.heaps.ii;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MinimumLargestElement {

    public int solve(ArrayList<Integer> A, int B) {

        //comparison based on (currentValue + originalValue)
        Comparator<Pair<Integer, Integer>> customComparator =
                Comparator.comparing(p -> Integer.valueOf(p.value.intValue() + A.get(p.index).intValue()));
        PriorityQueue<Pair<Integer, Integer>> minHeap = new PriorityQueue<>(customComparator);

        for (int i = 0; i < A.size(); i++) {
            minHeap.add(new Pair<>(A.get(i), i));
        }

        ArrayList<Integer> state = new ArrayList<>(A); //maintains current state of the array i.e after operation

        Pair<Integer, Integer> currMin;

        for (int i = 0; i < B; i++) {
            currMin = minHeap.poll();
            currMin.value += A.get(currMin.index);
            minHeap.add(new Pair<>(currMin.value, currMin.index)); //add back the updated Pair to heap
            state.set(currMin.index, currMin.value); //update the state array
        }

        return Collections.max(state); //pick the max element in the state array
    }

    static class Pair<T, U> {
        T value;
        U index;

        public Pair(T value, U index) {
            this.value = value;
            this.index = index;
        }
    }
}
