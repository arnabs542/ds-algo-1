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
/*
Candies in Box
Problem Description

There are 2 * N small boxes containing candies denoted by an integer array A of size 2 * N.

There are N-1 big boxes and each big box can accommodate exactly 2 small boxes.

So, we can use exactly 2 * (N-1) small boxes.

The cost of each big box is the absolute difference of candies in that box.

For example: A big box contain two small boxes with candies 4 and 6 then the cost of this big box will be | 4 - 6 | = 2.

You have to fill all the big boxes such that the total cost of big boxes are minimized.

Find and return the minimum total cost of big boxes.



Problem Constraints
1 <= N <= 50

1 <= A[i] <= 107



Input Format
First argument is an integer array A of size 2 * N.



Output Format
Return an integer denoting the minimum total cost of big boxes.



Example Input
A = [2, 4, 1, 10, 6, 15]


Example Output
3


Example Explanation
Since 2 * N = 6. So there are 2 big boxes, we can place 4 small boxes inside the 2 big boxes.
Inorder to minimize the cost, we will select boxes with candies (2, 1) and (4, 6). So the minimum cost will be 2 + 1 =3.

 */