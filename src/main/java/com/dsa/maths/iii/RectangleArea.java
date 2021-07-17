package com.dsa.maths.iii;

public class RectangleArea {

    public int solve(int A, int B, int C, int D, int E, int F, int G, int H) {
        /*
                    ____________(G,H)
                    |          |
            ________|____(C,D) |
            |       |    |     |
            |       |    |     |
            |       |____|_____|
            |   (E,F)    |
            |____________|
            (A,B)
        */

        //co-ordinates of overlapping rectangle
        int x1 = Math.max(A, E); //bottom left corner X co-ordinate
        int y1 = Math.max(B, F); //bottom left corner Y co-ordinate
        int x2 = Math.min(C, G); //top right corner X co-ordinate
        int y2 = Math.min(D, H); //top right corner Y co-ordinate

        //non overlapping case
        if (x1 >= x2 || y1 >= y2) {
            return 0;
        }
        return (x2 - x1) * (y2 - y1);
    }
}
/*
Rectangle Area
Problem Description

Given eight integers A, B, C, D, E, F, G and H which represent two rectangles in a 2D plane.

For the first rectangle it's bottom left corner is (A, B) and top right corner is (C, D) and for the second rectangle it's bottom left corner is (E, F) and top right corner is (G, H).

Find and return the overlapping area of the two rectangles.



Problem Constraints
-104 <= A <= C <= 104
-104 <= B <= D <= 104
-104 <= E <= G <= 104
-104 <= F <= H <= 104


Input Format
The eight arguments given are the integers A, B, C, D, E, F, G and H.



Output Format
Return the overlapping area of the two rectangles.



Example Input
Input 1:

 A = 0   B = 0
 C = 4   D = 4
 E = 2   F = 2
 G = 6   H = 6
Input 2:

 A = 0   B = 0
 C = 4   D = 4
 E = 2   F = 2
 G = 3   H = 3


Example Output
Output 1:

 4
Output 2:

 1

 */
