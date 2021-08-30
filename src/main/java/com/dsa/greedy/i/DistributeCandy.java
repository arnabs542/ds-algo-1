package com.dsa.greedy.i;

import java.util.ArrayList;

public class DistributeCandy {

    public int candy(ArrayList<Integer> A) {

        ArrayList<Integer> candies = new ArrayList<>();
        candies.add(1); //give 1 candy to first kid

        int totalCandies = 1;

        for (int i = 1; i < A.size(); i++) {
            if (A.get(i) > A.get(i - 1)) { //if rating is greater than left neighbour, give this kid one extra
                candies.add(i, (candies.get(i - 1)) + 1);
                totalCandies += candies.get(i);
            } else {
                candies.add(1); //rating is not greater but atleast one has to be given
                totalCandies++;
            }
        }

        //now traverse from back, and check with right neighbour
        for (int i = A.size() - 2; i >= 0; i--) {
            if (A.get(i) > A.get(i + 1) && (candies.get(i + 1) + 1) > candies.get(i)) {
                totalCandies -= candies.get(i);
                candies.set(i, candies.get(i + 1) + 1); //max of current and giving one extra
                totalCandies += candies.get(i);
            }
        }
        return totalCandies;
    }
}
