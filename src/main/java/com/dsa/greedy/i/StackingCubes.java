package com.dsa.greedy.i;

public class StackingCubes {
    public int solve(int A) {

        int count = 1; //for P=1
        //check pairs of factors
        for (int i = 2; i * i <= A; i++) {
            if (A % i == 0) {
                count += (A == i * i) ? 1 : 2; //for perfect square don't count twice as its the same pair
            }
        }
        return count;
    }
}
/*
Stacking Cubes
Problem Description

You are given A cubes that are of the same size. You are allowed to stack cubes on top of each other.

You should choose P cubes from the A cubes, such that you should stack all the remaining cubes on top of the P cubes, and each of the P cubes should have equal number of cubes on top of them.

Find and return the number of ways you can stack cubes on top of each other in the given manner.

NOTE: Every cube has to be stacked, you cannot have unstacked cubes. No stack can consist of a total of just one cube.



Problem Constraints
2 <= A <= 105



Input Format
First and only argument is an integer A denoting number of cubes.



Output Format
Return an integer denoting the number of ways you can stack cubes on top if each other in the above given manner.



Example Input
Input 1:

 A = 2
Input 2:

 A = 6


Example Output
Output 1:

 1
Output 2:

 3


Example Explanation
Explanation 1:

 Only one cube is stacked on another cube.
Explanation 2:

 You can have 5 cubes stacked on one cube, or 2 cubes stacked on one cube with a total of two stacks,
 or 1 cube stacked on one cube with a total of 3 stacks.

 */
