package com.dsa.recursion;

import java.util.ArrayList;
import java.util.Collections;

public class Subsets {

    private ArrayList<ArrayList<Integer>> ans = new ArrayList<>();

    public ArrayList<ArrayList<Integer>> subsets(ArrayList<Integer> A) {
        Collections.sort(A);
        getAllSubsets(new ArrayList<>(), 0, A);
        return ans;
    }

    //consider all choices available at currentIndex position of the currentSet
    private void getAllSubsets(ArrayList<Integer> currentSet, int currentIndex, ArrayList<Integer> A) {

        ans.add(new ArrayList<>(currentSet)); //add currentSet to result

        //pick next element among the choices and recurse, after returning unpick added element and consider next choices
        for (int i = currentIndex; i < A.size(); i++) {
            currentSet.add(A.get(i));
            getAllSubsets(currentSet, i + 1, A);
            currentSet.remove(currentSet.size() - 1);
        }
    }


}


