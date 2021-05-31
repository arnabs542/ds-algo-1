package com.main;

import com.dsa.graphs.v.TreeColoringWithThreeColors;

public class Main {

    public static void main(String[] args) {
//        ShortestDistanceInMaze p = new ShortestDistanceInMaze();
//
//        int[][] input = {
//                {0, 0, 1, 0, 0, 1, 0, 0, 1, 0},
//                {0, 0, 0, 1, 0, 0, 0, 0, 1, 0},
//                {0, 0, 1, 0, 1, 0, 1, 0, 0, 0},
//                {1, 0, 0, 0, 1, 1, 0, 0, 1, 0},
//                {1, 1, 0, 0, 1, 1, 1, 0, 0, 1},
//                {0, 0, 0, 0, 0, 1, 0, 1, 0, 0},
//                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
//                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0}};
//        int[] source = {7,5};
//        int[] destination = {4,2};
//        p.solve( input, source, destination);

//        MinimumWeightedCycle m = new MinimumWeightedCycle();
//        int[][] input = {
//                {1, 2, 2},
//                {2, 3, 3},
//                {3, 4, 1},
//                {4, 1, 4},
//                {1, 3, 15}
//        };
//        m.solve(4, input);

        TreeColoringWithThreeColors t = new TreeColoringWithThreeColors();
        t.solve("22000");
    }
}





