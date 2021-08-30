package com.dsa.graphs.iv;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class DamagedRoads {

    public int solve(int[] A, int[] B) {

        //stores weight and its direction i.e vertical or horizontal
        ArrayList<Pair> arr = new ArrayList<>();

        for (int i = 0; i < A.length; i++)
            arr.add(new Pair(A[i], 1));
        for (int i = 0; i < B.length; i++)
            arr.add(new Pair(B[i], 0));

        Comparator<Pair> customComp = (a, b) -> {
            return Integer.valueOf(a.weight).compareTo(Integer.valueOf(b.weight));
        };

        Collections.sort(arr, customComp); //sort by weights

        int n = A.length + 1;
        int m = B.length + 1;

        int minTotalCost = 0;

        //good logic
        for (Pair pair : arr) {

            if (pair.direction == 1) { //vertical
                minTotalCost += m * pair.weight; //there will be m edges of same weight
                n--; //decrement row
            } else {
                minTotalCost += n * pair.weight;
                m--;
            }
            minTotalCost %= 1000000007;
        }
        return minTotalCost;
    }

    static class Pair {
        int weight;
        int direction;

        Pair(int weight, int direction) {
            this.weight = weight;
            this.direction = direction;
        }
    }
}

