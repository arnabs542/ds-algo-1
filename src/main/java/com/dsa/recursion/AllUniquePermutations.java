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

