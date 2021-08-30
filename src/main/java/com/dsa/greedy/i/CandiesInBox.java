package com.dsa.greedy.i;

import java.util.ArrayList;
import java.util.Collections;

public class CandiesInBox {
    public int solve(ArrayList<Integer> A) {

        Collections.sort(A); //sorting will give us minimum possible absolute difference between adjacent pairs
        int globalSum = Integer.MAX_VALUE;

        for (int i = 0; i < A.size(); i++) {

            int one = A.get(i); //first eliminated candy

            for (int j = i + 1; j < A.size(); j++) {
                int sec = A.get(j);//second eliminated candy

                //remove the two candies
                A.remove(i);
                A.remove(j - 1);

                globalSum = Math.min(globalSum, totalSumAdjacentPairs(A)); //get ans by removing these two candies

                //add the removed candies back at the same position
                A.add(j - 1, sec);
                A.add(i, one);
            }
        }
        return globalSum;
    }

    //get sum of all pair wise absolute difference
    private int totalSumAdjacentPairs(ArrayList<Integer> A) {
        int sum = 0;
        for (int i = 0; (i + 1) < A.size(); i += 2) {
            sum += Math.abs(A.get(i) - A.get(i + 1));
        }
        return sum;
    }
}
