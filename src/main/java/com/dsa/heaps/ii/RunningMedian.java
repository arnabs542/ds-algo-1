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
/*
Running Median
Problem Description

Given an array of integers A denoting a stream of integers. New arrays of integer B and C are formed. Each time an integer is encountered in a stream, append it at the end of B and append median of array B at the C.

Find and return the array C.

NOTE:

If the number of elements are N in B and N is odd then consider median as B[N/2] ( B must be in sorted order).
If the number of elements are N in B and N is even then consider median as B[N/2-1]. ( B must be in sorted order).


Problem Constraints
1 <= length of the array <= 100000
1 <= A[i] <= 109



Input Format
The only argument given is the integer array A.



Output Format
Return an integer array C, C[i] denotes the median of first i elements.



Example Input
Input 1:

 A = [1, 2, 5, 4, 3]
Input 2:

 A = [5, 17, 100, 11]


Example Output
Output 1:

 [1, 1, 2, 2, 3]
Output 2:

 [5, 5, 17, 11]


Example Explanation
Explanation 1:

 stream          median
 [1]             1
 [1, 2]          1
 [1, 2, 5]       2
 [1, 2, 5, 4]    2
 [1, 2, 5, 4, 3] 3
Explanation 2:

 stream          median
 [5]              5
 [5, 17]          5
 [5, 17, 100]     17
 [5, 17, 100, 11] 11

 */
