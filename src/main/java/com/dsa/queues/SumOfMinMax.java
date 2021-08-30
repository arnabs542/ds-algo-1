package com.dsa.queues;

import java.util.ArrayDeque;
import java.util.Deque;

public class SumOfMinMax {
    private int mod = 1000000007;

    public int solve(int[] A, int B) {

        Deque<Integer> maxDeque = new ArrayDeque<>(); //indexes
        Deque<Integer> minDeque = new ArrayDeque<>();

        for (int i = 0; i < B; i++) {
            //pop unnecessary elems from maxDeque (from rear)
            while (!maxDeque.isEmpty() && A[maxDeque.peekLast()] <= A[i]) {
                maxDeque.pollLast();
            }
            //pop unncesseaary elems from minDeque (from rear)
            while (!minDeque.isEmpty() && A[minDeque.peekLast()] >= A[i]) {
                minDeque.pollLast();
            }
            maxDeque.addLast(i);
            minDeque.addLast(i);
        }

        long sum = 0L;
        for (int j = B; j < A.length; j++) {

            sum = (sum + (A[maxDeque.peekFirst()] + A[minDeque.peekFirst()] + mod) % mod + mod) % mod;

            //elem moving out is the max, remove it
            if (!maxDeque.isEmpty() && maxDeque.peekFirst() == j - B) {
                maxDeque.pollFirst();
            }
            //elem moving out is the min, remove it
            if (!minDeque.isEmpty() && minDeque.peekFirst() == j - B) {
                minDeque.pollFirst();
            }
            //pop unnecessary elems from maxDeque (from rear)
            while (!maxDeque.isEmpty() && A[maxDeque.peekLast()] <= A[j]) {
                maxDeque.pollLast();
            }
            //pop unncesseaary elems from minDeque (from rear)
            while (!minDeque.isEmpty() && A[minDeque.peekLast()] >= A[j]) {
                minDeque.pollLast();
            }
            maxDeque.addLast(j);
            minDeque.addLast(j);
        }
        sum = (sum + (A[maxDeque.peekFirst()] + A[minDeque.peekFirst()] + mod) % mod + mod) % mod;
        return (int) sum;
    }
}

