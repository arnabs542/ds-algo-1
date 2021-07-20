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

/*
Special Median
Problem Description

You are given an array A containing N numbers. This array is called special if it satisfies one of the following properties:

There exists an element A[i] in the array such that A[i] is equal to the median of elements [A[0], A[1], ...., A[i-1]]
There exists an element A[i] in the array such that A[i] is equal to the median of elements [A[i+1], A[i+2], ...., A[N-1]]
Median is the middle element in the sorted list of elements. If the number of elements are even then median will be (sum of both middle elements)/2.

Return 1 if the array is special else return 0.

NOTE:

For A[0] consider only the median of elements [A[1], A[2], ..., A[N-1]] (as there are no elements to the left of it)
For A[N-1] consider only the median of elements [A[0], A[1], ...., A[N-2]]


Problem Constraints
1 <= N <= 1000000.
A[i] is in the range of a signed 32-bit integer.



Input Format
First and only argument is an integer array A.



Output Format
Return 1 if the given array is special else return 0.



Example Input
Input 1:

 A = [4, 6, 8, 4]
Input 2:

 A = [2, 7, 3, 1]


Example Output
Output 1:

 1
Output 2:

 0


Example Explanation
Explantion 1:

 Here, 6 is equal to the median of [8, 4].
Explanation 2:

 No element satisfies any condition.

 */