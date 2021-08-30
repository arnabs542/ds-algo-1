package com.dsa.arraysNmath;

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

