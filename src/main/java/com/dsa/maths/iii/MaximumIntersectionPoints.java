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

