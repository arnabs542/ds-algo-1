package com.dsa.recursion.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetsII {

    private List<List<Integer>> ans;

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);

        ans = new ArrayList<>();
        allSubsets(nums, new ArrayList<>(), 0);
        return ans;
    }

    //consider all choices available at currIndex position of the currList
    private void allSubsets(int[] A, ArrayList<Integer> currList, int currIndex) {

        ans.add(new ArrayList<>(currList));

        for (int i = currIndex; i < A.length; i++) {

            // If element is considered for the first time in this function call, then don't skip
            if (i > currIndex && A[i] == A[i - 1]) {
                continue;
            }
            currList.add(A[i]);
            allSubsets(A, currList, i + 1);
            currList.remove(currList.size() - 1);
        }
    }
}

/*
90. Subsets II
Medium

Given an integer array nums that may contain duplicates, return all possible subsets (the power set).

The solution set must not contain duplicate subsets. Return the solution in any order.



Example 1:

Input: nums = [1,2,2]
Output: [[],[1],[1,2],[1,2,2],[2],[2,2]]
Example 2:

Input: nums = [0]
Output: [[],[0]]


Constraints:

1 <= nums.length <= 10
-10 <= nums[i] <= 10
 */