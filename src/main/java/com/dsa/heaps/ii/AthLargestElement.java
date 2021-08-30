package com.dsa.heaps.ii;

import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;

public class AthLargestElement {

    public ArrayList<Integer> solve(int A, ArrayList<Integer> B) {

        ArrayList<Integer> ans = new ArrayList<>(Collections.nCopies(A - 1, -1));

        PriorityQueue<Integer> minHeap = new PriorityQueue<>(); //has A no.s, root has most min element
        for (int i = 0; i < A; i++) {
            minHeap.add(B.get(i));
        }

        ans.add(minHeap.peek()); //least element will be smallest in A elements => Ath largest
        for (int i = A; i < B.size(); i++) {
            minHeap.add(B.get(i)); //insert incoming and remove min
            minHeap.poll();
            ans.add(minHeap.peek()); //now root will have Ath largest
        }
        return ans;
    }
}
