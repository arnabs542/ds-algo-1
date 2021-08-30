package com.dsa.heaps.ii;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class RunningMedian {

    public class Solution {

        public ArrayList<Integer> solve(ArrayList<Integer> A) {

            PriorityQueue<Integer> minHeap = new PriorityQueue<>(); //contains no.s greater than current median, right heap
            PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder()); //contains no.s less than current median, left heap
            maxHeap.add(A.get(0)); //add first element to left heap

            ArrayList<Integer> ans = new ArrayList<>();
            ans.add(A.get(0));

            for (int i = 1; i < A.size(); i++) {

                if (A.get(i) > maxHeap.peek()) { //if incoming elem > greatest elem of left heap, put into right heap
                    minHeap.add(A.get(i));
                    if (minHeap.size() - maxHeap.size() > 1) {//if sizes differ by more than 1, rebalance
                        maxHeap.add(minHeap.poll());
                    }
                } else {
                    maxHeap.add(A.get(i));
                    if (maxHeap.size() - minHeap.size() > 1) {
                        minHeap.add(maxHeap.poll());
                    }
                }

                if (maxHeap.size() >= minHeap.size())
                    ans.add(maxHeap.peek());
                else
                    ans.add(minHeap.peek());
            }
            return ans;
        }
    }
}

