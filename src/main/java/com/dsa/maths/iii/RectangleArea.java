package com.dsa.maths.iii;

public class RectangleArea {

    public int solve(int A, int B, int C, int D, int E, int F, int G, int H) {


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

