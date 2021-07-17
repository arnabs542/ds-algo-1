package com.dsa.maths.iii;

public class MaximumIntersectionPoints {
    public int getIntersection(int N, int M) {
        // N lines
        // M circles
        // lines with lines = Nc2 * 1
        // circles with circles = Mc2 * 2
        // lines with circles = Mc1*Nc1 * 2
        return (N * (N - 1) / 2) + (2 * N * M) + (2 * M * (M - 1) / 2);
    }
}
/*
Maximum Intersection Points
Problem Description

You are given A lines and B circles. Find the maximum number of intersection points that these A lines and B circles can have with each other.



Problem Constraints
0 <= A,B <= 10000



Input Format
First argument is an integer A denoting the number of lines.
Second argument is an integer B denoting the number of circles.



Output Format
Return an integer denoting the maximum number of intersection points.



Example Input
Input 1:

A = 2
B = 2


Example Output
output 1:

11


Example Explanation
Explanaton 1:

Two circles can intersect at 2 points.
Two lines can intersect at only 1 point.
Two lines and two circles can intersect at 8 points.
So, total maximum number of intersection points are 11.

 */
