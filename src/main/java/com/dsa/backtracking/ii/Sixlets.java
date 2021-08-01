package com.dsa.backtracking.ii;

import java.util.ArrayList;

public class Sixlets {

    private ArrayList<Integer> input;
    private int count;

    public int solve(ArrayList<Integer> a, int B) {
        input = new ArrayList<>();
        count = 0;
        input.addAll(a);

        subsequenceCount(new ArrayList<>(), 0, 0, B);
        return count;
    }

    private void subsequenceCount(ArrayList<Integer> currentSet, int currentIndex, int currentSum, int size) {

        if (currentSum > 1000 || currentSet.size() > size) {
            return;
        }

        if (currentIndex == input.size()) {
            if (currentSum <= 1000 && currentSet.size() == size) {
                count++;
            }
            return;
        }

        currentSet.add(input.get(currentIndex)); //add currentIndex element
        subsequenceCount(currentSet, currentIndex + 1, currentSum + input.get(currentIndex), size);//get all subseq incl. currentIndex element

        currentSet.remove(currentSet.size() - 1);//need to remove added element
        subsequenceCount(currentSet, currentIndex + 1, currentSum, size);//get all subseq excl. currentIndex element
    }
}
/*
SIXLETS
Problem Description

Given an array of integers A of size N and an integer B.

Return number of non-empty subsequences of A of size B having sum <= 1000.



Problem Constraints
1 <= N <= 20

1 <= A[i] <= 1000

1 <= B <= N



Input Format
The first argument given is the integer array A.

The second argument given is the integer B.



Output Format
Return number of subsequences of A of size B having sum <= 1000.



Example Input
Input 1:

    A = [1, 2, 8]
    B = 2
Input 2:

    A = [5, 17, 1000, 11]
    B = 4


Example Output
Output 1:

3
Output 2:

0


Example Explanation
Explanation 1:

 {1, 2}, {1, 8}, {2, 8}
Explanation 1:

 No valid subsequence

 */