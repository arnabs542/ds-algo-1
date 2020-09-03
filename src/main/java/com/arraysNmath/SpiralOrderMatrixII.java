package com.arraysNmath;

public class SpiralOrderMatrixII {

    public int[][] generateMatrix(int A) {

        int[][] arr = new int[A][A];

        // this logic helps in avoiding overwriting at corners
        int rowStart = 0;
        int rowEnd = A - 1;
        int colStart = 0;
        int colEnd = A - 1;

        int no = 1;
        while (rowStart <= rowEnd && colStart <= colEnd) {

            for (int i = colStart; i <= colEnd; i++) {// from 0,0 left -> right
                arr[rowStart][i] = no++;
            }
            rowStart++;

            for (int i = rowStart; i <= rowEnd; i++) {// top -> down
                arr[i][colEnd] = no++;
            }
            colEnd--;

            for (int i = colEnd; i >= colStart; i--) {// right -> left
                arr[rowEnd][i] = no++;
            }
            rowEnd--;

            for (int i = rowEnd; i >= rowStart; i--) {// down -> top
                arr[i][colStart] = no++;
            }
            colStart++;
        }
        return arr;
    }
}

/*
Problem Description

Given an integer A, generate a square matrix filled with elements from 1 to A2 in spiral order.



Problem Constraints
1 <= A <= 1000



Input Format
First and only argument is integer A


Output Format
Return a 2-D matrix which consists of the elements in spiral order.



Example Input
Input 1:

1
Input 2:

2


Example Output
Output 1:

[ [1] ]
Output 2:

[ [1, 2], [4, 3] ]


Example Explanation
Explanation 1:


Only 1 is to be arranged.
Explanation 2:

1 --> 2
      |
      |
4<--- 3
 */