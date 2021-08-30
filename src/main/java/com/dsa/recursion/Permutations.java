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

