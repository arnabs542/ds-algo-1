package com.dsa.recursion;

import java.util.ArrayList;
import java.util.Collections;

public class CombinationSumII {

    private ArrayList<ArrayList<Integer>> ans = new ArrayList<>();

    public ArrayList<ArrayList<Integer>> combinationSum(ArrayList<Integer> input, int b) {
        Collections.sort(input);

        getAllSubsets(input, new ArrayList<>(), 0, b);
        return ans;
    }

    private void getAllSubsets(ArrayList<Integer> input, ArrayList<Integer> currentSet, int currentIndex, int remSum) {

        if (remSum == 0) {
            ans.add(new ArrayList<>(currentSet));
            return;
        }
        if (remSum < 0) {
            return;
        }

        for (int i = currentIndex; i < input.size(); i++) {

            if (i > currentIndex && input.get(i) == input.get(i - 1)) {
                continue;
            }
            currentSet.add(input.get(i));
            getAllSubsets(input, currentSet, i + 1, remSum - input.get(i));
            currentSet.remove(currentSet.size() - 1);
        }
    }
}
