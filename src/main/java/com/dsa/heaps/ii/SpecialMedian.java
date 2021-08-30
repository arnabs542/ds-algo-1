package com.dsa.heaps.ii;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class SpecialMedian {

    public int solve(ArrayList<Integer> A) {

        if (A.size() == 1)
            return 0;

        //same logic as running median problem
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
        maxHeap.add(A.get(0));

        for (int i = 1; i < A.size(); i++) {
            //check if current median(excluding current elem) equals current element
            if (Double.valueOf(A.get(i)).equals(findMedian(minHeap, maxHeap)))
                return 1;
            addNumber(A.get(i), minHeap, maxHeap); //add the current elem to either of the heap
        }

        maxHeap.clear();
        minHeap.clear();
        maxHeap.add(A.get(A.size() - 1));

        for (int i = A.size() - 2; i >= 0; i--) {
            //check if current median(excluding current elem) equals current element
            if (Double.valueOf(A.get(i)).equals(findMedian(minHeap, maxHeap)))
                return 1;
            addNumber(A.get(i), minHeap, maxHeap);
        }
        return 0;
    }

    private Double findMedian(PriorityQueue<Integer> minHeap, PriorityQueue<Integer> maxHeap) {
        if (maxHeap.size() == minHeap.size()) //means even no. of elements in total, so median will be average of two middle elements
            return (Double.valueOf(maxHeap.peek()) + Double.valueOf(minHeap.peek())) / 2;

        if (maxHeap.size() > minHeap.size())
            return Double.valueOf(maxHeap.peek());

        return Double.valueOf(minHeap.peek());
    }

    private void addNumber(int number, PriorityQueue<Integer> minHeap, PriorityQueue<Integer> maxHeap) {
        if (number > maxHeap.peek()) {
            minHeap.add(number);
            if (minHeap.size() - maxHeap.size() > 1)
                maxHeap.add(minHeap.poll());
        } else {
            maxHeap.add(number);
            if (maxHeap.size() - minHeap.size() > 1)
                minHeap.add(maxHeap.poll());
        }
    }
}

