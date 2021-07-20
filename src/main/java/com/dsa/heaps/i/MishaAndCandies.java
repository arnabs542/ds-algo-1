package com.dsa.heaps.i;

import java.util.ArrayList;
import java.util.Collections;

public class MishaAndCandies {

    public int solve(ArrayList<Integer> A, int B) {

        ArrayList<Integer> minHeap = build(A); //build minHeap

        int ans = 0;
        while (minHeap.size() > 1) {

            int min = minHeap.get(1);
            if (min > B) { //condition given in question
                break;
            }
            ans += min / 2;
            deleteRoot(minHeap); //delete current as it will not be used again

            if (minHeap.size() > 1) { //add remaining to newMin and rebuild heap
                int newMin = minHeap.get(1);
                minHeap.set(1, newMin + (min - (min / 2)));
                percolateDown(1, minHeap);
            }
        }
        return ans;
    }

    //index from which we want to perculateDown
    private void percolateDown(int index, ArrayList<Integer> heap) {

        while (index > 0 && index < heap.size()) {

            int leftIndex = 2 * index;
            int rightIndex = 2 * index + 1;

            int left = leftIndex < heap.size() ? heap.get(leftIndex) : Integer.MAX_VALUE;
            int right = rightIndex < heap.size() ? heap.get(rightIndex) : Integer.MAX_VALUE;

            if (heap.get(index) <= left && heap.get(index) <= right) {
                break;
            }

            int smallerChildIndex = left < right ? leftIndex : rightIndex;

            Collections.swap(heap, index, smallerChildIndex);
            index = smallerChildIndex;
        }
    }

    //index from which we want to perculateUp
    private void percolateUp(int index, ArrayList<Integer> heap) {

        while (index > 1) {

            int parentIndex = (index) / 2;
            if (heap.get(index) >= heap.get(parentIndex)) {
                break;
            }

            Collections.swap(heap, index, parentIndex);
            index = parentIndex;
        }
    }

    private void deleteRoot(ArrayList<Integer> heap) {
        if (heap.size() <= 1) {
            return;
        }
        Collections.swap(heap, 1, heap.size() - 1);
        heap.remove(heap.size() - 1);

        percolateDown(1, heap);
    }

    private void insert(int n, ArrayList<Integer> heap) {
        heap.add(n);
        percolateUp(heap.size() - 1, heap);
    }

    private ArrayList<Integer> build(ArrayList<Integer> input) {
        input.add(0, Integer.MAX_VALUE);
        for (int i = input.size() - 1; i > 0; i--) {
            percolateDown(i, input);
        }
        return input;
    }
}
/*
Misha and Candies
Problem Description

Misha loves eating candies. She has given N boxes of Candies.

She decides, every time she will choose a box having the minimum number of candies, eat half of the candies and put the remaining candies in the other box that has the minimum number of candies.
Misha does not like a box if it has the number of candies greater than B so she won't eat from that box. Can you find how many candies she will eat?

NOTE 1: If a box has an odd number of candies then Misha will eat floor(odd/2).

NOTE 2: A same box will not be chosen again.



Problem Constraints
1 <= N <= 105

1 <= A[i] <= 105

1 <= B <= 106



Input Format
The first argument is A an Array of Integers, where A[i] is the number of candies in the ith box.
The second argument is B, the maximum number of candies Misha like in a box.



Output Format
Return an Integer denoting number of candies Misha will eat.



Example Input
Input 1:

 A = [3, 2, 3]
 B = 4
Input 2:

 A = [1,2,1]
 B = 2


Example Output
Output 1:

 2
Output 2:

 1


Example Explanation
Explanation 1:

 1st time Misha will eat from 2nd box, i.e 1 candy she'll eat and will put the remaining 1 candy in the 1st box.
 2nd time she will eat from the 3rd box, i.e 1 candy she'll eat and will put the remaining 2 candies in the 1st box.
 She will not eat from the 3rd box as now it has candies greater than B.
 So the number of candies Misha eat is 2.
Explanation 2:

 1st time Misha will eat from 1st box, i.e she can't eat any and will put the remaining 1 candy in the 3rd box.
 2nd time she will eat from the 3rd box, i.e 1 candy she'll eat and will put the remaining 1 candies in the 2nd box.
 She will not eat from the 2nd box as now it has candies greater than B.
 So the number of candies Misha eat is 1.

 */
