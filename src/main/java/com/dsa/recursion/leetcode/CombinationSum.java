package com.dsa.recursion.leetcode;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {

    private List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        getAllSubsets(candidates, new ArrayList<>(), 0, target);
        return ans;
    }

    private void getAllSubsets(int[] input, ArrayList<Integer> currentSet, int currentIndex, int remSum) {

        if (remSum == 0) {
            ans.add(new ArrayList<>(currentSet));
            return;
        }
        if (remSum < 0) {
            return;
        }

        for (int i = currentIndex; i < input.length; i++) {
            currentSet.add(input[i]);
            getAllSubsets(input, currentSet, i, remSum - input[i]); //since unlimited times we can choose an element
            currentSet.remove(currentSet.size() - 1);
        }
    }
}
