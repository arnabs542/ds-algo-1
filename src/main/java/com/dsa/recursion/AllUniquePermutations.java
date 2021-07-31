package com.dsa.recursion;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AllUniquePermutations {

    private List<List<Integer>> ans;

    public List<List<Integer>> permute(ArrayList<Integer> A) {
        ans = new ArrayList<>();
        permutations(A, 0);
        return ans;
    }

    private void permutations(ArrayList<Integer> A, int currentIndex) {

        if (currentIndex == A.size()) {//nothing left to permute, so add
            ans.add(new ArrayList<Integer>());
            return;
        }

        ArrayList<Integer> visited = new ArrayList<>();

        for (int i = currentIndex; i < A.size(); i++) {//swap currentIndex element with all other elements and then permute again

            if (!visited.contains(A.get(i))) {//permute only if unique element occurs

                Collections.swap(A, i, currentIndex);
                permutations(A, currentIndex + 1);//permute keeping elements till currentIndex as is
                Collections.swap(A, currentIndex, i);//we need to backtrack, so swapping again

                visited.add(A.get(i));
            }
        }
    }
}
/*
All Unique Permutations
Problem Description

Given an array A of size N denoting collection of numbers that might contain duplicates, return all possible unique permutations.

NOTE: No 2 entries in the permutation sequence should be the same.

WARNING: DO NOT USE LIBRARY FUNCTION FOR GENERATING PERMUTATIONS. Example : next_permutations in C++ / itertools.permutations in python.
If you do, we will disqualify your submission retroactively and give you penalty points.


Problem Constraints
1 <= |A| <= 9

0 <= A[i] <= 10



Input Format
Only argument is an integer array A of size N.



Output Format
Return a 2-D array denoting all possible unique permutation of the array.



Example Input
Input 1:

A = [1, 1, 2]
Input 2:

A = [1, 2]


Example Output
Output 1:

[ [1,1,2]
  [1,2,1]
  [2,1,1] ]
Output 2:

[ [1, 2]
  [2, 1] ]


Example Explanation
Explanation 1:

 All the possible unique permutation of array [1, 1, 2].
Explanation 2:

 All the possible unique permutation of array [1, 2].

 */
