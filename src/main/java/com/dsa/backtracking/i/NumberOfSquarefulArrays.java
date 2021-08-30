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

