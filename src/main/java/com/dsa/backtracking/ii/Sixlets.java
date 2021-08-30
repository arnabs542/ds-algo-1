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
