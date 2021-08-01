package com.dsa.backtracking.i;

import java.util.ArrayList;
import java.util.Collections;

public class NumberOfSquarefulArrays {

    private int count;

    public int solve(ArrayList<Integer> A) {
        count = 0;
        if (A.size() <= 1) {
            return 0;
        }
        permute(A, 0);
        return count;
    }

    private void permute(ArrayList<Integer> A, int currentIndex) {

        if (currentIndex == A.size()) {
            count++;
            return;
        }

        ArrayList<Integer> visited = new ArrayList<>();//same logic as unique permutations question

        for (int i = currentIndex; i < A.size(); i++) {
            if (!visited.contains(A.get(i))) {
                visited.add(A.get(i));
                // if perfect square, then only go for other permutations
                if (currentIndex == 0 || (isPerfectSquare(A.get(currentIndex - 1) + A.get(i)))) {
                    Collections.swap(A, currentIndex, i);
                    permute(A, currentIndex + 1);
                    Collections.swap(A, i, currentIndex);
                }
            }
        }
    }

    private boolean isPerfectSquare(int a) {
        int x = (int) Math.sqrt(a);
        return x * x == a;
    }
}

/*
Number of Squareful Arrays
Problem Description

Given an array of integers A, the array is squareful if for every pair of adjacent elements, their sum is a perfect square.

Find and return the number of permutations of A that are squareful. Two permutations A1 and A2 differ if and only if there is some index i such that A1[i] != A2[i].



Problem Constraints
1 <= length of the array <= 12

1 <= A[i] <= 109



Input Format
The only argument given is the integer array A.



Output Format
Return the number of permutations of A that are squareful.



Example Input
Input 1:

 A = [2, 2, 2]
Input 2:

 A = [1, 17, 8]


Example Output
Output 1:

 1
Output 2:

 2


Example Explanation
Explanation 1:

 Only permutation is [2, 2, 2], the sum of adjacent element is 4 and 4 and both are perfect square.
Explanation 2:

 Permutation are [1, 8, 17] and [17, 8, 1].

 */