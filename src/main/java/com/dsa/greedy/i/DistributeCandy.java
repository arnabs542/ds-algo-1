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
/*
Distribute Candy
Problem Description

There are N children standing in a line. Each child is assigned a rating value.

You are giving candies to these children subjected to the following requirements:

Each child must have at least one candy.
Children with a higher rating get more candies than their neighbors.
What is the minimum candies you must give?



Problem Constraints
1 <= N <= 105
-109 <= A[i] <= 109



Input Format
First and only argument is an integer array A representing the rating of children.



Output Format
Return an integer, representing the minimum candies to be given.



Example Input
Input 1:

 A = [1, 2]
Input 2:

 A = [1, 5, 2, 1]


Example Output
Output 1:

 3
Output 2:

 7


Example Explanation
Explanation 1:

 The candidate with 1 rating gets 1 candy and candidate with rating 2 cannot get 1 candy as 1 is its neighbor.
 So rating 2 candidate gets 2 candies. In total, 2 + 1 = 3 candies need to be given out.
Explanation 2:

 Candies given = [1, 3, 2, 1]
 */