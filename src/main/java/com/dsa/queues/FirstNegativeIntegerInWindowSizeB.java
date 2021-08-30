package com.dsa.queues;

import java.util.ArrayDeque;
import java.util.Deque;

public class FirstNegativeIntegerInWindowSizeB {

    public int[] solve(int[] A, int B) {

        Deque<Integer> queue = new ArrayDeque<>();//front of queue will have the first negative elem

        for (int i = 0; i < B; i++) { //check first window for negative no.
            if (A[i] < 0) {
                queue.add(A[i]);
            }
        }
        //if queue is empty, means no negative elem so put 0 (int[] initialized to 0 anyway)
        int[] ans = new int[A.length - B + 1];
        if (!queue.isEmpty()) {
            ans[0] = queue.peekFirst(); //update ans with first negative elem in first window
        }

        for (int j = B; j < A.length; j++) {
            if (!queue.isEmpty() && A[j - B] == queue.peekFirst()) { //if outgoing elem == front of queue, remove from queue
                queue.pollFirst();
            }
            if (A[j] < 0) { //incoming elem is negative, add to queue as it can be answer for future windows
                queue.add(A[j]);
            }
            if (!queue.isEmpty()) {
                ans[j - B + 1] = queue.peekFirst(); //update ans with first negative elem in current window
            }
        }
        return ans;
    }
}

