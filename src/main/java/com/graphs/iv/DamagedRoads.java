package com.graphs.iv;

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

/*

Damaged Roads
Problem Description

You are the Prime Minister of a country and once you went for a world tour.
After 5 years, when you returned to your country, you were shocked to see the condition of the roads between the cities. So, you plan to repair them, but you cannot afford to spend a lot of money.

The country can be represented as a (N+1) x (M+1) grid, where Country(i, j) is a city.

The cost of repairing a road between (i, j) and (i + 1, j) is A[i]. The cost of repairing a road between (i, j) and (i, j + 1) is B[j].

Return the minimum cost of repairing the roads such that all cities can be visited from city indexed (0, 0).

As the cost can be large, return the cost modulo 109+7.



Problem Constraints
1 <= N, M <= 105

1 <= A[i], B[i] <= 103


Input Format
The first argument will be an integer array, A, of size N.
The second argument will be an integer array, B, of size M.



Output Format
Return an integer representing the minimum possible cost.



Example Input
Input 1:

 A = [1, 1, 1]
 B = [1, 1, 2]
Input 2:

 A = [1, 2, 3]
 B = [4, 5, 6]


Example Output
Output 1:

 16
Output 2:

 39


Example Explanation
Explanation 1:

 The minimum cost will be 16 if we repair the roads in the following way:
 Repair the roads from the all cities in row 0 to row 1 i.e. (0, j) to (1, j) (0 <= j <= 3), so that the cost will be 4 (A[0] * 4).
 Repair the roads from the all cities in row 1 to row 2 i.e. (1, j) to (2, j) (0 <= j <= 3), so that the cost will be 4 (A[1] * 4).
 Repair the roads from the all cities in row 2 to row 3 i.e. (2, j) to (3, j) (0 <= j <= 3), so that the cost will be 4 (A[2] * 4).
 Repair the roads (0, 0) to (0, 1), (0, 1) to (0, 2), (0, 2) to (0, 3), so that the cost will be B[0] + B[1] + B[2] = 4.
 Total cost will be 16.

Explanation 2:

 The minimum possible cost will be 39.
 */