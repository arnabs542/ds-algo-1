package com.dsa.recursion;

import java.util.ArrayList;
import java.util.Collections;

public class Permutations {

    private ArrayList<ArrayList<Integer>> ans;

    public ArrayList<ArrayList<Integer>> permute(ArrayList<Integer> A) {
        ans = new ArrayList<>();
        permutations(A, 0);
        return ans;
    }

    private void permutations(ArrayList<Integer> A, int currentIndex) {

        if (currentIndex == A.size()) {//nothing left to permute, so add
            ans.add(new ArrayList<>(A));
            return;
        }

        for (int i = currentIndex; i < A.size(); i++) {//swap currentIndex element with all other elements and then permute again
            Collections.swap(A, i, currentIndex);//swap and permute
            permutations(A, currentIndex + 1);//permute keeping elements till currentIndex as is
            Collections.swap(A, currentIndex, i);//we need to backtrack, so swapping again
        }
    }
}
/*
Permutations
Problem Description

Given an integer array A of size N denoting collection of numbers , return all possible permutations.

NOTE:

No two entries in the permutation sequence should be the same.
For the purpose of this problem, assume that all the numbers in the collection are unique.
Return the answer in any order
WARNING: DO NOT USE LIBRARY FUNCTION FOR GENERATING PERMUTATIONS. Example : next_permutations in C++ / itertools.permutations in python.
If you do, we will disqualify your submission retroactively and give you penalty points.


Problem Constraints
1 <= N <= 9



Input Format
Only argument is an integer array A of size N.



Output Format
Return a 2-D array denoting all possible permutation of the array.



Example Input
A = [1, 2, 3]


Example Output
[ [1, 2, 3]
  [1, 3, 2]
  [2, 1, 3]
  [2, 3, 1]
  [3, 1, 2]
  [3, 2, 1] ]


Example Explanation
All the possible permutation of array [1, 2, 3].

 */
